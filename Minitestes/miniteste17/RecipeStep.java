import java.util.Map;
import java.util.TreeMap;

public class RecipeStep implements Comparable<RecipeStep>{
    private String name;
    private String action;

    private TreeMap<Ingredient,Float> flo_ingredients = new TreeMap<>();

    private TreeMap<RecipeStep,Integer> int_ingredients = new TreeMap<>();

    public RecipeStep(String name, String action) throws IllegalArgumentException {
        if(name == null || action == null)
            throw new IllegalArgumentException();
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getAction() {
        return action;
    }

    public void addIngredient(Ingredient ingredient, float quantity) {
        if(flo_ingredients.containsKey(ingredient))
            return;
        flo_ingredients.put(ingredient,quantity);
    }

    public void addIngredient(RecipeStep recipe, Integer quantity) {
        if(int_ingredients.containsKey(recipe))
            return;
        int_ingredients.put(recipe,quantity);
    }

    public TreeMap<RecipeStep, Integer> getInt_ingredients() {
        return int_ingredients;
    }

    public float getQuantity(Ingredient ingredient) {
        float amount =0;
        if(flo_ingredients.containsKey(ingredient))
            amount += flo_ingredients.get(ingredient);
        for(Map.Entry<RecipeStep,Integer> recipes : int_ingredients.entrySet()) {
           amount += recipes.getKey().getQuantity(ingredient)*recipes.getValue();
        }
        return amount;
    }

    public int getQuantity(RecipeStep recipe) {

        if(int_ingredients.containsKey(recipe))
            return int_ingredients.get(recipe);
        else return 0;
    }

    public int getIngredientCount() {
        return flo_ingredients.size()+int_ingredients.size();
    }

    public int compareTo(RecipeStep recipe) {
        if (this.name.compareTo(recipe.getName()) == 0)
            return this.action.compareTo(recipe.getAction());
        else
            return this.name.compareTo(recipe.getName());
    }

    public String toString() {
        String buf = "to make " + this.name + ", " + this.action + " ";
        boolean begin = true;
        for(Map.Entry<RecipeStep,Integer> recipes : int_ingredients.entrySet()) {
            if(begin) {
                begin = false;
                buf += getQuantity(recipes.getKey()) + ".0 " + recipes.getKey().getName();
            }
            else
                buf += ", " + getQuantity(recipes.getKey()) + ".0 " + recipes.getKey().getName();

        }

        for(Map.Entry<Ingredient,Float> recipes : flo_ingredients.entrySet()) {
            if(begin) {
                begin = false;
                buf += getQuantity(recipes.getKey()) + " " + recipes.getKey().getName();
            }
            else
                buf += ", " + getQuantity(recipes.getKey()) + " " + recipes.getKey().getName();

        }
        return buf;
    }
}
