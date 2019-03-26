public class Attendee extends Person {
    private boolean paid;

    Attendee(String name) {
        super(name);
        paid = false;
    }

    Attendee(String name,int age) {
        super(name,age);
        paid = false;
    }

    public boolean hasPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Attendee "+getName()+(hasPaid() ? " has":" hasn't")+" paid its registration.";
    }
}
