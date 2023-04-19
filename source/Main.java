package source;

import java.util.HashMap;
import java.util.Scanner;

import Goals.Goal;
import Workouts.Workout;


public class Main {
    private static User USER;
    private static Workout WORKOUT;
    private static Goal GOAL;

    enum Command {
        HELP,
        LOGIN,
        WORKOUT
    }

    public static boolean input(Scanner scanner) {
        System.out.println(">> ");
        String inputString = scanner.nextLine();
        System.out.println(inputString);

        for (Command c : Command.values()) {
            if (c.toString().toLowerCase().equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    public static void login(Scanner scanner) {
        while (true) {
            System.out.println("please login or create an account: (login / create)");
            String command = scanner.nextLine();
            if (command.equals("login") || command.equals("create")) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // if command is to create new user, prompt to make new user with given name
                if (command.equals("create")) {
                    USER = makeNewUser(scanner, username);
                    login.add_user(USER, password);
                }
                try {
                    USER = login.authenticate(username, password);
                    System.out.println("Hello " + USER.getName());
                    break;
                } catch (NullPointerException e) {
                    System.out.println("Wrong password or username.");
                }
            } else {
                break;
            }
        }
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
        if(command.equals("yes")){
            System.out.println("congradulations you completed a " + WORKOUT.getIntensity() + " calories/min intensity workout that was " + WORKOUT.getDuration() + " minuts long. Started on: " + WORKOUT.getTime_date());
            System.out.println("total amount of calories burned: " + WORKOUT.getIntensity()*WORKOUT.getDuration() );
        }
        //add workout to personal history
        USER.getDailyInfo().addWorkout(WORKOUT);
        //show history
        System.out.println("workout was added to history, to view type History");
        String commandh = scanner.nextLine();
        if(commandh.equals("History")) {
            USER.getDailyInfo().getWorkoutHistory();
        }
    }

    public static Workout makeNewWorkout(String intensity) {
        DailyInfo map = USER.getDailyInfo();
        Object currentT = map.getDailyInfo().get("Target Calories");
        if(intensity.equals("High")){
            USER.getDailyInfo().setTarget((int)currentT + 600);
            return new Workout(60,10);
        }else if(intensity.equals("Medium")){
            USER.getDailyInfo().setTarget((int)currentT + 450);
            return new Workout(60,7.5);
        }else {
            USER.getDailyInfo().setTarget((int)currentT + 300);
            return new Workout(60, 5);
        }
    }

    public static User makeNewUser(Scanner scanner, String name) {
        System.out.print("Enter birthday <YYYY-MM-DD>: ");
        String birthday = scanner.nextLine();

        System.out.print("Enter height <cm>: ");
        int height = scanner.nextInt();

        System.out.print("Enter weight <Kg>: ");
        int weight = scanner.nextInt();

        return new User(name, height, weight, birthday);
    }

    public static void goal(Scanner scanner) {
        System.out.println("Please choose a weight goal. (Current weight: " + USER.getWeight() + ")");
        int weightGoal = scanner.nextInt();
        GOAL = new Goal(USER, weightGoal);
        GOAL.setCalories();
        USER.getDailyInfo().setTarget((int)GOAL.getTargetCalories());
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, Welcome To nutriApp, your own fitness companion!");
        try {
            // Prompt the user to log in or create an account
            login(scanner);

            // Prompt the user to choose weight goal
            goal(scanner);
            System.out.println("Your current daily target calories are: " + USER.getDailyInfo());


            //scanner.reset();
            // Ask user if they want to do workout and for how long
            System.out.println("type workout to pick workout");
            String command = scanner.nextLine();
            if (command.equals("")) {
                String command2 = scanner.nextLine();
                if (command2.equals("workout")) {
                    workout(scanner);
                }
            }
            System.out.println("Your current daily target calories are now: " + USER.getDailyInfo().getTargetCalories());
            // show stock
            //show meal
            //view goal for the day

            //R2
            //change password
            System.out.println("enter new password");
            String newPass = scanner.nextLine();
            USER.resetPassword(newPass);

        }catch(Exception e){
            System.out.println("System exit.");
        }
        scanner.close();
    }

}
