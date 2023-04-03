package source;

import java.util.Scanner;

public class Main {
    
    enum Command {
        HELP,
        LOGIN
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

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, Welcome To nutriApp, your own fitness companion!");
        while (true) {
            if (input(scanner)) {
                break;
            }
        }
        scanner.close();
    }
    
}
