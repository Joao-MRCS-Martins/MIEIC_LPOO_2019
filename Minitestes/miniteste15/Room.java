import java.util.ArrayList;
import java.util.List;

public class Room extends Facility {
    private Building building;
    private String number;
    private int floor;
    private List<User> authorized;

    Room(Building building,String number,int floor) throws IllegalArgumentException, DuplicateRoomException {
        super(building.getName()+number);
        this.building = building;
        if(floor < building.getMinFloor() || floor > building.getMaxFloor())
            throw new IllegalArgumentException();
        this.number = number;
        this.floor = floor;
        for(Room room : building.getRooms())
            if(this.equals(room))
                throw new DuplicateRoomException();
        building.addRoom(this);
        authorized = new ArrayList<>();
    }

    Room(Building building,String number,int floor,int capacity) throws IllegalArgumentException,DuplicateRoomException {
        super(building.getName()+number);
        this.building = building;
        if(floor < building.getMinFloor() || floor > building.getMaxFloor() || capacity < 0)
            throw new IllegalArgumentException();
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
        for(Room room : building.getRooms())
            if(this.equals(room))
                throw new DuplicateRoomException();
        building.addRoom(this);
        authorized = new ArrayList<>();

    }

    public String getName() {
        return building.getName() + number;
    }

    public Building getBuilding() {
        return building;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Room("+this.building.getName()+","+this.number+")";
    }

    @Override
    public boolean equals(Object u1) {
        if(this == u1) return true;
        if(u1 == null) return false;
        if(getClass() != u1.getClass()) return false;
        return this.number.equals(((Room) u1).getNumber()) && this.building.equals(((Room)u1).getBuilding());
    }
}
