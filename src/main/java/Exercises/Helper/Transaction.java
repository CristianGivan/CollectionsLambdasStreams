package Exercises.Helper;

public class Transaction {
    private int id;
    private int amount;
    private Account accountFrom;

    public Transaction(int id, int amount, Account accountFrom) {
        this.id = id;
        this.amount = amount;
        this.accountFrom = accountFrom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", accountFrom=" + accountFrom +
                '}';
    }
}
