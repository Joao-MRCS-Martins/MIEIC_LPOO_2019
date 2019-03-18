public class House implements HasArea {
    double area;

    House(double a) {area = a;}

    @Override
    public double getArea() {
        return area;
    }
}
