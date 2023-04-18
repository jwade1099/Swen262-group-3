package Composite;

import java.util.ArrayList;
import java.util.List;

public class Ingredients implements Food {
    private double calories;
    private String name;


    public Ingredients(double calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    @Override
    public double getCalories() {
        return calories;
    }

    @Override
    public List<Food> getFood() {
        List<Food> foods = new ArrayList<>();
        foods.add(this);
        return foods;
    }



}

