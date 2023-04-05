package Composite;

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

}

