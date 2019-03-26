public class Deposit extends Transaction{

    Deposit(ATM a, Session s, Card c, int id) {
        super(a,s,c,id);
    }

    public String toString() {
        return "Deposit " + super.toString();
    }
}
