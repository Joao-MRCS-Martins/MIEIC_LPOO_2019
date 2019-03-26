public class Transaction {
    private ATM ATM;
    private Session session;
    private Card card;
    private int ID;
    private double amount;

    Transaction(ATM a, Session s, Card c, int id) {
        ATM =a;
        session = s;
        card = c;
        ID = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return  "at ATM " + ATM.getID() + " (" + ATM.getLocal() + ", " + ATM.getBank() + ") of " + String.format("%.2f", amount);
    }
}
