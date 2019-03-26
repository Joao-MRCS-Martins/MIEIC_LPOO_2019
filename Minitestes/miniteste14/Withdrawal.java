public class Withdrawal extends Transaction {

    Withdrawal(ATM a, Session s, Card c, int id) {
        super(a, s, c, id);
    }

    public String toString() {
        return "Withdrawal " + super.toString();
    }
}
