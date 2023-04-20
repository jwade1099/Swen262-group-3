package source;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class login {
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public static void add_user(User user, String password) {
        JSONObject userJSON = new JSONObject();
        String hashedPassword = String.valueOf(password.hashCode());
        userJSON.put("username", user.getName()); // username for the user
        userJSON.put("password", hashedPassword); // sets the password
        userJSON.put("Height", user.getHeight()); // user height
        userJSON.put("Weight", user.getWeight()); // user weight
        userJSON.put("Birthday", user.getBirthday()); // user birthday
        userJSON.put("weightGoal", user.getGoal().getWeightGoal()); // user weight goal

        JSONObject userObject = new JSONObject();
        userObject.put("user", userJSON);

        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("source/user.json"));
            JSONArray userList = (JSONArray) obj;
            userList.add(userObject);

            FileWriter file = new FileWriter("source/user.json");
            //We can write any JSONArray or JSONObject instance to the file
            file.write(userList.toJSONString());
            file.flush();
            file.close();
            System.out.println(GREEN + "New user created" + RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User authenticate(String username, String password) throws NullPointerException {
        String hashedPassword = String.valueOf(password.hashCode());

        JSONParser parser = new JSONParser(); // makes a new parser 

        try (FileReader reader = new FileReader("source/user.json")) { // reads the file
            Object obj = parser.parse(reader);

            JSONArray userList = (JSONArray) obj;

            for (int i = 0; i < userList.size(); i++) {
                JSONObject element = (JSONObject) userList.get(i);
                JSONObject user = (JSONObject) element.get("user");


                String user1 = (String) user.get("username");

                String pass1 = String.valueOf(user.get("password"));


                if (user1.equals(username) && pass1.equals(hashedPassword)) {
                    System.out.println(GREEN + "User found" + RESET);
                    int height = (int) (long) user.get("Height");
                    int weight = (int) (long) user.get("Weight");
                    String birthday = (String) user.get("Birthday");
                    int weightGoal = (int) (long) user.get("weightGoal");
                    return new User(user1, height, weight, birthday, weightGoal);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void logOut(String username, int weightGoal) {
        JSONParser parser = new JSONParser(); // makes a new parser
        try (FileReader reader = new FileReader("source/user.json")) { // reads the file
            Object obj = parser.parse(reader);

            JSONArray userList = (JSONArray) obj;

            for (int i = 0; i < userList.size(); i++) {
                JSONObject element = (JSONObject) userList.get(i);
                JSONObject user = (JSONObject) element.get("user");

                String user1 = (String) user.get("username");

                if (user1.equals(username)){
                    user.remove("weightGoal");
                    System.out.println(GREEN + "Logging out..." + RESET);
                    user.put("weightGoal", weightGoal);
                    FileWriter file = new FileWriter("source/user.json");
                    file.write(userList.toJSONString());
                    file.flush();
                    file.close();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();


        // add_user(user, password);

        User user = authenticate(username, password);

        if (user != null) {
            System.out.println("Logged in");
            System.out.println(user.toString());
        } else {
            System.out.println("no such user");
        }


        scanner.close();

    }

}