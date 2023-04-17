package Composite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class Composite {
    public static void main(String[] args) {
        Food ingredient1 = new Ingredients(100, 20);
        Food ingredient2 = new Ingredients(200, 30);


        List<Food> foodsList = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("Composite/foods.json"));
            
            JSONObject jsonObject = (JSONObject)obj;

            System.out.println(jsonObject.toString());
            


            String name = (String)jsonObject.get("users.Name");
            System.out.println(name);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }





        

        

        
        

        
        

        //Food recipe1 = new Recipe()
    
    }
}
