package source;

import java.util.Scanner;

import Goals.Goal;
import org.json.simple.JSONObject;


public class Main {
    private static User USER;
    private static Goal GOAL;
    
    enum Command {
        HELP,
        LOGIN,
        WORKOUT
    };

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

    public static void login() {
        
    }
     
    public static void workout(Scanner scanner) {
        String inputString = scanner.nextLine();
        System.out.println("please choose High, Medium, or Low workout.");
        if(inputString == "High"){
            System.out.println("you picked High");
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, Welcome To nutriApp, your own fitness companion!");

        while(true) {
            System.out.println("please login or create an account: (login / create)");
            String command = scanner.nextLine();
            if (command.equals("login") || command.equals("create")) {
                System.out.println("Enter username");
                String username = scanner.nextLine();
                System.out.println("Enter password");
                String password = scanner.nextLine();

                if(command.equals("create")) login.add_user(username, password);
                
                JSONObject user = login.authenticate(username, password);

                String name = (String)user.get("username");
                break;

            }
        }

        
        scanner.close();
    }
    
}
