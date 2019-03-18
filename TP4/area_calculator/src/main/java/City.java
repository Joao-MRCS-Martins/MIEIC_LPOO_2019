import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider {
    List<House> houses = new ArrayList<>();

    City(List<House> houses) { this.houses = houses;}
    public void addHouse(House h1) {
        houses.add(h1);
    }

    public double sum() {
        double sum =0;
        for(House h: houses) {
            sum += h.getArea();
        }
        return sum;
    }
}
