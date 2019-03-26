public class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object u1) {
        if(this == u1) return true;
        if(u1 == null) return false;
        if(getClass() != u1.getClass()) return false;
        return this.name.equals(((User) u1).getName());
    }
}
