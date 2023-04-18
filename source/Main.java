package source;

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
    }

    public static Workout makeNewWorkout(String intensity) {

        return new Workout(100, 7.5);
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
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, Welcome To nutriApp, your own fitness companion!");
        try {
            // Prompt the user to log in or create an account
            login(scanner);

            // Prompt the user to choose weight goal
            goal(scanner);
            System.out.println("Your current daily target calories are: " + GOAL.getTargetCalories());

            // Ask user if they want to do workout and for how long
            String command = scanner.nextLine();
            if (command.equals("workout")) {
                workout(scanner);
            }
            //show stock
            //show meal
            //view goal for the day
        }catch(Exception e){
            System.out.println("System exit.");
        }
        scanner.close();
    }

}
