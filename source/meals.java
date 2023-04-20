package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import Composite.*;

public class meals {


    public static ArrayList<Food> low_food() {

        ArrayList<String> codes = new ArrayList<>();

        codes.add("01002");

        ArrayList<Food> recipes = new ArrayList<>(); // arraylist full of ingredients

        ArrayList<Food> meals = new ArrayList<>(); // arraylist full of meals



        String line = "";

        try   {  
        //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("ingredients.csv"));  
            while ((line = br.readLine()) != null) {  
            String[] foodDetails = line.split(",");    // seperates using a comma
            if (codes.contains(foodDetails[0])) {
                System.out.println(foodDetails[0]);

                int calories = Integer.parseInt(foodDetails[3]) ;
                String name = foodDetails[1];
                Ingredients ingredient = new Ingredients(calories, name);
                recipes.add(ingredient);

            }
        }  

            br.close();
        }   
        catch (Exception e)   
        {  
        e.printStackTrace();  
        }  
        


        return recipes;
    }

    public static void main(String[] args) {
        low_food();
    }


    
}
