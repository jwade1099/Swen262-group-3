package Composite;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Food {

    private double calories;
    private List<Food> foods;

    public Recipe(List<Food> foods) {
        this.calories = 0;
        this.foods = new ArrayList<>();

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
    public List<Food> getFood() {
        return foods;
    }
    
}
