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

        String line = "";

        try   {  
        //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("ingredients.csv"));  
            while ((line = br.readLine()) != null) {  
            String[] foodDetails = line.split(",");    // seperates using a comma
            if (codes.contains(foodDetails[0])) {
                System.out.println(foodDetails[0]);
            }
            }  

            br.close();
        }   
        catch (Exception e)   
        {  
        e.printStackTrace();  
        }  
        


        return null;
    }

    public static void main(String[] args) {
        low_food();
    }


    
}
