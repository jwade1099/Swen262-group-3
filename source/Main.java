package source;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import Goals.Goal;
import Workouts.Workout;
import org.junit.platform.console.shadow.picocli.CommandLine;


public class Main {
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    private static final String COMMANDS = """
            Please choose a command out of the following:
            <H>-To show commands again.
            <G>-To select a weight goal.
            <W>-To select workout intensity.
            <U>-To see user history.
            <L>-To log out.
            <E>-To exit.
            >>\s""";
    private static boolean loggedIn = false;


    private static User USER;
    private static Workout WORKOUT;
    private static Goal GOAL;

    public static void login(Scanner scanner) {
        String c = """
                Please select one of the following commands:
                <L>-To login.
                <C>-To create a new account.
                <E>-To exit program.
                >>\s""";
        String command = "";
        while (!command.equals("E")) {
            System.out.print(c);
            command = scanner.nextLine();
            if (command.equals("L") || command.equals("C")) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // if command is to create new user, prompt to make new user with given name
                if (command.equals("C")) {
                    USER = makeNewUser(username);
                    login.add_user(USER, password);
                }
                try {
                    USER = login.authenticate(username, password);
                    System.out.println("Hello " + USER.getName() + "!!\n");
                    command = "E";
                    loggedIn = true;
                } catch (NullPointerException e) {
                    System.out.println(RED + "Wrong password or username.\n" + RESET);
                }
            }
        }
    }

    public static Command printCommands(Scanner scanner) {
        System.out.print(COMMANDS);

        return switch (scanner.nextLine()) {
            case "H" -> Command.HELP;
            case "G" -> Command.GOAL;
            case "W" -> Command.WORKOUT;
            case "U" -> Command.USER_HISTORY;
            case "L" -> Command.LOGOUT;
            case "E" -> Command.EXIT;
            default -> Command.DEFAULT;
        };
    }

    public static void goal(Scanner scanner) {
        System.out.println("Please choose a weight goal. (Current weight: " + USER.getWeight() + ")");
        int weightGoal = scanner.nextInt();
        scanner.nextLine();
        GOAL = new Goal(USER, weightGoal);
        GOAL.setCalories();
        USER.getDailyInfo().setTarget((int) GOAL.getTargetCalories());
        System.out.println("Your current daily target calories are: " + USER.getDailyInfo().getTargetCalories());
    }

    public static void workout(Scanner scanner) {
        System.out.println("please choose High, Medium, or Low workout.");
        String inputString = scanner.nextLine();
        if (inputString.equals("High")) {
            System.out.println("you picked a High workout");
            WORKOUT = makeNewWorkout("High");
        } else if (inputString.equals("Medium")) {
            WORKOUT = makeNewWorkout("Medium");
            System.out.println("you picked a Medium workout");
        } else if (inputString.equals("Low")) {
            WORKOUT = makeNewWorkout("Low");
            System.out.println("you picked a Low workout");
        }
        //asks to do workout
        System.out.println("to finish your workout type yes");
        String command = scanner.nextLine();
        if (command.equals("yes")) {
            System.out.println("congradulations you completed a " + WORKOUT.getIntensity() + " calories/min intensity workout that was " + WORKOUT.getDuration() + " minuts long. Started on: " + WORKOUT.getTime_date());
            System.out.println("total amount of calories burned: " + WORKOUT.getIntensity() * WORKOUT.getDuration());
        }
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

    public static User makeNewUser(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter birthday <YYYY-MM-DD>: ");
        String birthday = scanner.nextLine();

        System.out.print("Enter height <cm>: ");
        int height = scanner.nextInt();

        System.out.print("Enter weight <Kg>: ");
        int weight = scanner.nextInt();

        scanner.close();
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
                        System.out.println(GREEN + "You selected GOALS" + RESET);
                        goal(sc);
                        break;
                    case WORKOUT:
                        System.out.println(GREEN + "You selected WORKOUTS" + RESET);
                        workout(sc);
                        break;
                    case USER_HISTORY:
                        System.out.println(GREEN + "You selected USER HISTORY" + RESET);
                        System.out.println(RED + "INSERT USER HISTORY LOGIC" + RESET);
                        USER.getDailyInfo().getWorkoutHistory();
                        break;
                    case LOGOUT:
                        System.out.println(GREEN + "Logging out..." + RESET);
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
