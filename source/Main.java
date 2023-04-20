package source;

import java.util.ArrayList;
import java.util.Scanner;

import Goals.Goal;
import Workouts.Workout;
import Composite.*;



public class Main {
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    private static final String COMMANDS = """
            Please choose a command out of the following:
            <H>-To show commands again.
            <G>-To view goals menu.
            <W>-To select workout intensity.
            <U>-To see user history.
            <F>-To get foods
            <L>-To log out.
            <E>-To exit.
            >>\s""";
    private static boolean loggedIn = false;


    private static User USER;
    private static Workout WORKOUT;

    public static void login(Scanner scanner) {
        String c = """
                Please select one of the following commands:
                <L>-To login.
                <C>-To create a new account.
                <E>-To exit program.
                >>\s""";
        String command = "";
        while (!command.equals("E")) {
            System.out.println(CYAN + "/////// LOGIN MENU ///////" + RESET);
            System.out.print(c);
            command = scanner.nextLine();
            if (command.equals("L") || command.equals("C")) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // if command is to create new user, prompt to make new user with given name
                if (command.equals("C")) {
                    USER = makeNewUser(scanner, username);
                    login.add_user(USER, password);
                }
                try {
                    USER = login.authenticate(username, password);
                    USER.getGoal().setCalories();
                    System.out.println("Hello " + USER.getName() + "!!\n");
                    loggedIn = true;
                    break;
                } catch (NullPointerException e) {
                    System.out.println(RED + "Wrong password or username.\n" + RESET);
                }
            }
        }
    }

    public static Command printCommands(Scanner scanner) {
        System.out.println(CYAN + "/////// MAIN MENU ///////");
        System.out.println(GREEN + "Current user: " + USER.getName() + RESET);
        System.out.print(COMMANDS);

        return switch (scanner.nextLine()) {
            case "H" -> Command.HELP;
            case "G" -> Command.GOAL;
            case "W" -> Command.WORKOUT;
            case "U" -> Command.USER_HISTORY;
            case "L" -> Command.LOGOUT;
            case "F" -> Command.FOOD;
            case "E" -> Command.EXIT;
            default -> Command.DEFAULT;
        };
    }

    public static void goal(Scanner scanner) {
        String command = "";
        while (!command.equals("B")) {
            String commands = """
                    Please choose a command out of the following:
                    <V>-To view current weight goal.
                    <S>-To set new weight goal.
                    <B>-To return to main menu.
                    >>\s""";
            System.out.print(commands);
            command = scanner.nextLine();

            switch (command) {
                case "V":
                    Goal goal = USER.getGoal();
                    System.out.println(GREEN + "Your current goal is to " + goal.getState() + "Kg.");
                    System.out.println("Your current daily target calories is: " + goal.getTargetCalories() + " calories." + RESET);
                    break;
                case "S":
                    newGoal(scanner);
                    break;
                case "B":
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    public static void newGoal(Scanner scanner) {
        System.out.print("Please choose a weight goal. (Current weight: " + USER.getWeight() + ")\n>> ");
        int weightGoal = scanner.nextInt();
        scanner.nextLine();
        USER.setWeightGoal(weightGoal);
        System.out.println(GREEN + "Your current daily target calories are: " + USER.getGoal().getTargetCalories() + RESET);
    }

    public static void workout(Scanner scanner) {
        System.out.println("please choose High, Medium, or Low workout.");
        String inputString = scanner.nextLine();
        switch (inputString) {
            case "High" -> {
                System.out.println("you picked a High workout");
                WORKOUT = makeNewWorkout("High");
            }
            case "Medium" -> {
                WORKOUT = makeNewWorkout("Medium");
                System.out.println("you picked a Medium workout");
            }
            case "Low" -> {
                WORKOUT = makeNewWorkout("Low");
                System.out.println("you picked a Low workout");
            }
        }
        System.out.println("congratulations you completed a " + WORKOUT.getIntensity() + " calories/min intensity workout that was " + WORKOUT.getDuration() + " minutes long. Started on: " + WORKOUT.getTime_date());
        System.out.println("total amount of calories burned: " + WORKOUT.getIntensity() * WORKOUT.getDuration());

        //add workout to personal history
        USER.getDailyInfo().addWorkout(WORKOUT);

        //show history
        System.out.println("workout was added to user history");
        System.out.println("Your current daily target calories are now: " + USER.getDailyInfo().getTargetCalories());
    }

    public static Workout makeNewWorkout(String intensity) {
        DailyInfo map = USER.getDailyInfo();
        Object currentT = map.getDailyInfo().get("Target Calories");
        if (intensity.equals("High")) {
            USER.getDailyInfo().setTarget((int) currentT + 600);
            return new Workout(60, 10);
        } else if (intensity.equals("Medium")) {
            USER.getDailyInfo().setTarget((int) currentT + 450);
            return new Workout(60, 7.5);
        } else {
            USER.getDailyInfo().setTarget((int) currentT + 300);
            return new Workout(60, 5);
        }
    }

    public static ArrayList<Food> makeNewFood() {

        ArrayList<String> codes = new ArrayList<>();
        codes.add("01002");


        
        ArrayList<Food> meal = Meals.makeFood(codes);
        System.out.println(meal.get(0));
        Recipe recipe = new Recipe(meal);

        System.out.println("the meal for you consists of " + recipe.getFood() + " and is " + recipe.getCalories());

        return null;
    }

    public static User makeNewUser(Scanner scanner, String name) {
        System.out.print("Enter birthday <YYYY-MM-DD>: ");
        String birthday = scanner.nextLine();

        System.out.print("Enter height <cm>: ");
        int height = scanner.nextInt();

        System.out.print("Enter weight <Kg>: ");
        int weight = scanner.nextInt();
        scanner.nextLine();

        return new User(name, height, weight, birthday);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, Welcome To nutriApp, your own fitness companion!");

        // prompt the user to login
        login(sc);

        while (loggedIn) {
            Command command = Command.DEFAULT;
            while (!command.equals(Command.EXIT)) {
                command = printCommands(sc);
                switch (command) {
                    case HELP:
                        break;
                    case GOAL:
                        System.out.println(CYAN + "/////// GOALS ///////" + RESET);
                        goal(sc);
                        break;
                    case WORKOUT:
                        System.out.println(CYAN + "/////// WORKOUTS ///////" + RESET);
                        workout(sc);
                        break;
                    case USER_HISTORY:
                        System.out.println(CYAN + "/////// USER HISTORY ///////" + RESET);
                        USER.getPersonalHistory().printHistory();
                        break;

                    case FOOD:
                        System.out.println(GREEN + "You selected the foods" + RESET);
                        makeNewFood();
                        break;

                    case LOGOUT:
                        login.logOut(USER.getName(), USER.getGoal().getWeightGoal());
                        loggedIn = false;
                        login(sc);
                        command = loggedIn ? Command.DEFAULT : Command.EXIT;
                        break;
                    case EXIT:
                        command = Command.EXIT;
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("The command entered doesn't exist.");
                }
            }
        }
        // show stock
        //show meal
        //view goal for the day

        //R2
        //change password
//            System.out.println("enter new password");
//            String newPass = scanner.nextLine();
//            USER.resetPassword(newPass);

        sc.close();
    }
}
