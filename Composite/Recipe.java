package Composite;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Food {

    private double calories;
    private List<Ingredients> foods;

    public Recipe(List<Ingredients> foods) {
        this.calories = 0;
        this.foods = foods;

    }

    @Override
    public double getCalories() {
        calories = 0;
        for (Food food : foods) {
            calories += food.getCalories();
        }
        return calories;
    }

    @Override
    public String getFood() {
        String foodString = "";

        for (Ingredients ingredient : this.foods) {
            foodString += (ingredient.getName() + " ");

        }
        return foodString;


    }
    
}
