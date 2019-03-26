import java.util.TreeMap;

public class OvenStep extends RecipeStep {
    private String name;
    private String action;
    private int temperature;
    private TreeMap<Ingredient,Integer> ingredients = new TreeMap<>();

    public OvenStep(String name, String action, int temperature) {
        super(name,action);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void addIngredient(Ingredient ingredient, Integer quantity) {
        if(ingredients.containsKey(ingredient))
            return;
        ingredients.put(ingredient,quantity);
    }

    public float getQuantity(Ingredient ingredient) {
        if(ingredients.containsKey(ingredient))
            return ingredients.get(ingredient);
        else return 0;
    }
}
