import java.util.ArrayList;

public class Countable {
    protected ArrayList<Transaction> transactions;

    public int count() {
        return transactions.size();
    }
}
