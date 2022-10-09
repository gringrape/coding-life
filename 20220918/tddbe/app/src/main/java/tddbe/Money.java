package tddbe;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money other = (Money) object;
        return currency().equals(other.currency()) &&
                amount == other.amount;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    public Expression times(int multiplier) {
        return new Money(this.amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
