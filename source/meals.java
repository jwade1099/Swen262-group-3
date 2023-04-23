package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;




import Composite.*;

public class meals {


    public static ArrayList<Ingredients> makeFood(ArrayList<String> codes) {

        // codes = new ArrayList<>();

        // codes.add("01002");

        ArrayList<Ingredients> recipes = new ArrayList<>(); // arraylist full of ingredients

        String line = "";

        try   {  
        //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("ingredients.csv"));  
            while ((line = br.readLine()) != null) {  
                if (!line.contains("\"")) continue;
               
            String[] foodDetails1 = line.split("\"");    // seperates using a quotes to get the name

            String description = foodDetails1[1]; // takes the first index which is the description

            String newLine = line.replace(description, " "); // makes new line without the string of the name

            String[] foodDetails2 = newLine.split(",");    // seperates using a comma

            if (!codes.contains(foodDetails2[0])) continue; // continues if the desired code is not in

            double calories = 0;
            try {
                calories = Double.parseDouble(foodDetails2[3].replace(",", ""));

            } catch(NumberFormatException e) {
                continue;
            }

            // System.out.println("Description: " + description);
            // System.out.println("calories:" + calories);

            Ingredients food = new Ingredients(calories, description);

            // System.out.println(food.getName());
            // System.out.println(food.getCalories());

            recipes.add(food); // arraylist of ingredients which makes a recipe

        }  

            br.close();
        }   
        catch (Exception e)   
        {  
        e.printStackTrace();  
        }  
        
        // System.out.println(recipes.get(0));

        return recipes;
    }

    // public static void main(String[] args) {
    //     ArrayList<String> codes = new ArrayList<>();
    //     ArrayList<Food> recipes = makeFood(codes);

    //     for (Food recipe : recipes) {
    //         System.out.println(recipe.getCalories());
    //     }
    // }


    
}
