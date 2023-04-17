package Composite;

import java.util.ArrayList;
import java.util.List;

public class Ingredients implements Food {
    private double calories;
    private int stock;


    public Ingredients(double calories, int stock) {
        this.calories = calories;
        this.stock = stock;
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

