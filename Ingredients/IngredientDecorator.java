public class IngredientDecorator extends Ingredient{
    protected Ingredient ingredient;

    public IngredientDecorator(Ingredient ingredient) {
        super(ingredient.getName(), new float[]{ingredient.getCals(), ingredient.getProtein(), ingredient.getCarbs(), ingredient.getFiber(), ingredient.getFats()});
        this.ingredient = new Ingredient(ingredient.getName(), new float[]{ingredient.getCals(), ingredient.getProtein(), ingredient.getCarbs(), ingredient.getFiber(), ingredient.getFats()});
    }
}