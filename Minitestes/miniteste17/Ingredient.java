public abstract class Ingredient implements Comparable<Ingredient> {
    private String name;

    public Ingredient(String name) throws IllegalArgumentException {
        this.name = name;
        if(name == null)
            throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if( this == o) return true;
        if(o == null) return false;
        if(!(o instanceof SimpleIngredient)) return false;

        return this.name.equals(((SimpleIngredient)o).getName());
    }

    @Override
    public int compareTo(Ingredient o) {
        return this.name.compareTo(o.getName());
    }

    public String toString() {
        return this.name;
    }
}
