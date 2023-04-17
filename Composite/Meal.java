package Composite;

import java.util.ArrayList;
import java.util.List;

import Goals.Goal;

public class Meal implements Food {
    /**
     * Meal class has a list of food objects from ingredient class
     * get calories cycles through lsit of ingredients
     */
    private double calories;
    private List<Food> foods;
    private Goal goal;

    public Meal(Goal goal) {
        this.foods = new ArrayList<>();
        this.calories = 0;
        this.goal = goal;
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
