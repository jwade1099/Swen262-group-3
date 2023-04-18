package source;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class login {
    
    public static void add_user(String username, String password) {
        JSONObject user = new JSONObject(); 
        String hashedPassword = String.valueOf(password.hashCode());
        user.put("username", username); // username for the user
        user.put("password", hashedPassword); // sets the password
        
        JSONObject userObject = new JSONObject();
        userObject.put("user", user);
        
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("source/user.json"));
            JSONArray userList =  (JSONArray) obj;
            userList.add(userObject);
            
            FileWriter file = new FileWriter("source/user.json");
            //We can write any JSONArray or JSONObject instance to the file
            file.write(userList.toJSONString()); 
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    public static JSONObject authenticate(String username, String password) {
        String hashedPassword = String.valueOf(password.hashCode());
        
        JSONParser parser = new JSONParser(); // makes a new parser 
        
        try(FileReader reader = new FileReader("source/user.json")) { // reads the file
            Object obj = parser.parse(reader);
            
            JSONArray userList = (JSONArray) obj;
            
            for (int i =0; i < userList.size();i++) {
                JSONObject element = (JSONObject)userList.get(i);
                JSONObject user = (JSONObject) element.get("user");
                
                
                String user1 = (String)user.get("username");
                
                String pass1 = String.valueOf(user.get("password"));
                
                
                if (user1.equals(username) && pass1.equals(hashedPassword)) {
                    System.out.println("User found");
                    return user;
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
    
    
       // add_user(username, password);
    
        JSONObject user =  authenticate(username, password); 
    
        if (user != null) {
            System.out.println("Logged in");
            System.out.println(user.toString());
        }
        else {
            System.out.println("no such user");
        }
    
        
        scanner.close();
    
    }
    
}