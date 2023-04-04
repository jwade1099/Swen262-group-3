public class Ingredient {
    private String name;
    private float cals;
    private float protein;
    private float carbs;
    private float fiber;
    private float fats;

    public Ingredient(String name, float[] information){
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
    public float getCals() {
        return cals;
    }
    public float getProtein() {
        return protein;
    }
    public float getCarbs() {
        return carbs;
    }
    public float getFiber() {
        return fiber;
    }
    public float getFats() {
        return fats;
    }
    
}