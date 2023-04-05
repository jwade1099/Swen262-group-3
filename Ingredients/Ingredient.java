public class Ingredient {
    private String name;
    private double cals;
    private double protein;
    private double carbs;
    private double fiber;
    private double fats;

    public Ingredient(String name, double[] information){
        this.name = name;
        this.cals = information[1];
        this.protein = information[2];
        this.carbs = information[3];
        this.fiber = information[4];
        this.fats = information[5];
    }

    public String getName() {
        return name;
    }
    public double getCals() {
        return cals;
    }
    public double getProtein() {
        return protein;
    }
    public double getCarbs() {
        return carbs;
    }
    public double getFiber() {
        return fiber;
    }
    public double getFats() {
        return fats;
    }
    
}