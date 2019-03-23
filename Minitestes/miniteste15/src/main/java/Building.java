import java.util.ArrayList;
import java.util.List;

public class Building extends Facility{
    private String name;
    private int minFloor;
    private int maxFloor;
    private List<Room> rooms;

    Building(String name, int minF, int maxF) throws IllegalArgumentException {
        super(name);
        if(maxF < minF) {
            throw new IllegalArgumentException();
        }
        minFloor = minF;
        maxFloor = maxF;
        capacity = 0;
        rooms = new ArrayList<>();
    }

    Building(String name, int minF, int maxF,int capacity) throws IllegalArgumentException {
        super(name);
        if(maxF < minF || capacity <0) {
            throw new IllegalArgumentException();
        }
        minFloor = minF;
        maxFloor = maxF;
        capacity = 0;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    @Override
    public String toString() {
        return "Building("+this.getName()+")";
    }

    public void addRoom(Room a1) {
        rooms.add(a1);
        capacity += a1.capacity;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public boolean canEnter(User u1) {
        for (Room room : rooms) {
            if (room.canEnter(u1))
                return true;
        }
        return false;
    }
}
