package Composite;

import java.util.ArrayList;
import java.util.List;

public class Meal implements Food {
    private double calories;
    private List<Food> foods;

    public Meal() {
        this.foods = new ArrayList<>();
        this.calories = 0;
    }
    
    @Override
    public double getCalories() {
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
