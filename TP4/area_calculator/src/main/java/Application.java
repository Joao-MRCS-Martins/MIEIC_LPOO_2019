import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        AreaAggregator a1 = new AreaAggregator();

        a1.addArea(new Circle(4));
        a1.addArea(new Square(2));
        a1.addArea(new Square(4));
        a1.addArea(new Ellipse(2,4));
        a1.addArea(new Triangle(2,2));
        a1.addArea(new House(300));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(a1);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(a1);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());


        List<House> houses = new ArrayList<>();
        houses.add(new House(50));
        houses.add(new House(150));

        City city = new City(houses);

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXmlOutputter = new AreaXMLOutputter(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXmlOutputter.output());
    }
}