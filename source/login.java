package source;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class login {

    public static void add_user(User user, String password) {
        JSONObject userJSON = new JSONObject();
        String hashedPassword = String.valueOf(password.hashCode());
        userJSON.put("username", user.getName()); // username for the user
        userJSON.put("password", hashedPassword); // sets the password
        userJSON.put("Height", user.getHeight()); // user height
        userJSON.put("Weight", user.getWeight()); // user weight
        userJSON.put("Birthday", user.getBirthday()); // user birthday
 
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
            System.out.println("New user created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User authenticate(String username, String password) {
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
                    System.out.println("User found");
                    int height = (int) (long) user.get("Height");
                    int weight = (int) (long) user.get("Weight");
                    String birthday = (String) user.get("Birthday");
                    return new User(user1, height, weight, birthday);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

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