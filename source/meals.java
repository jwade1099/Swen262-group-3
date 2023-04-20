package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import com.opencsv.*;




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
                if (!line.contains("\"")) continue;
            String[] foodDetails1 = line.split("\"");    // seperates using a quotes to get the name

            String description = foodDetails1[1]; // takes the first idnex which is the description

            String newLine = line.replace(description, " "); // makes new line without the string of the name

            String[] foodDetails2 = newLine.split(",");    // seperates using a comma

            double calories = 0;
            try {
                calories = Double.parseDouble(foodDetails2[3].replace(",", ""));

            } catch(NumberFormatException e) {
                continue;
            }



            System.out.println("Description: " + description);
            System.out.println("calories:" + calories);

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
