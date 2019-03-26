import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Recipe {
    private String name;
    private TreeSet<RecipeStep> steps;

    public Recipe(String name) {
        this.name = name;
        steps = new TreeSet<>();
    }

    public void addStep(RecipeStep step) {
        steps.add(step);
    }

    public int getStepCount() {
        return steps.size();
    }
}
