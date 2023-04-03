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
        // TODO Auto-generated method stub
        return 0;
    }
    
}
