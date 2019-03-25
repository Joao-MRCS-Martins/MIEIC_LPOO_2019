import java.util.ArrayList;

public class Session extends Countable{
    private ATM ATM;

    Session( ATM atm) {
        this.ATM = atm;
        transactions = new ArrayList<Transaction>();
    }

    public ATM getATM() {
        return ATM;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public boolean equals(Object o) {
        return getATM().equals(((Session)o).getATM());
    }
}
