package Composite;

import java.util.ArrayList;
import java.util.List;

public class Meal implements Food {
    private double calories;

    private List<Food> foods;

    public Meal() {
        this.calories = 0;
        this.foods = new ArrayList<>();
    }

    @Override
    public double getCalories() {
        return calories;
    }

    private void calculateCalories() {
        for (int i = 0; i < foods.size(); i++) {
            Food currentFood = foods.get(i);
            calories += currentFood.getCalories();
        }
    }
    
}
