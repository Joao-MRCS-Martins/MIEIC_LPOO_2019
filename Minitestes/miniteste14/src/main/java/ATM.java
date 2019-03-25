public class ATM {
    private int ID;
    private String local;
    private String bank;

    ATM (int id, String local,String bank) {
        this.ID = id;
        this.local = local;
        this.bank = bank;
    }


    public String getLocal() {
        return local;
    }

    public String getBank() {
        return bank;
    }

    public int getID() {
        return ID;
    }

    public boolean equals(Object o) {
        return ID == ((ATM)o).getID() && local.equals(((ATM)o).getLocal()) && bank.equals(((ATM)o).getBank());
    }
}
