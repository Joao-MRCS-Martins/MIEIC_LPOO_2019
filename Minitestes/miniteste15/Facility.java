import java.util.ArrayList;
import java.util.List;

public class Facility {
    protected String name;
    protected int capacity;
    protected List<User> authorized;

    public Facility(String name) {
        this.name = name;
        authorized = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean canEnter(User u1) {
        return authorized.contains(u1);
    }

    public boolean authorize(User u1) {
        return authorized.add(u1);
    }
}
