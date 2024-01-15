package bank.kata;

public class Account {
    private final int balance;

    public Account(int amount) {
        balance = amount;
    }

    public int balance() {
        return balance;
    }

    public Account deposit(int amount) {
        return new Account(balance + amount);
    }

    public Account withdraw(int amount) throws Exception {
        if (balance < amount) {
            throw new InsufficientBalanceException("Not enough balance");
        }

        return new Account(balance - amount);
    }
}
