package Composite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.*;
import org.json.simple.parser.*;


public class Composite {
    public static void main(String[] args) {
        Food ingredient1 = new Ingredients(100, "20");
        Food ingredient2 = new Ingredients(200, "30");


        List<Food> foodsList = new ArrayList<>();

        // JSONParser parser = new JSONParser();
        // try {
        //     Object obj = parser.parse(new FileReader("Composite/foods.json"));
            
        //     JSONObject jsonObject = (JSONObject)obj;

        //     System.out.println(jsonObject.toString());
            
            


        //     String name = (String)jsonObject.get("name");
        //     System.out.println(name);

        //     jsonObject.put("hello", "world");

          
        //     FileWriter file = new FileWriter("Composite/foods.json");
        //     file.write(jsonObject.toJSONString());
        //     file.close();
        

        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }


        // Food recipe1 = new Recipe(foodsList);
    
    }
}
