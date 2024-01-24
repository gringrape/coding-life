package tdd;


public class Money implements Expression {
    protected String currency;

    protected int amount;

    public Money(int amount, String currency) {
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
        Money money = (Money) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    String currency() {
        return currency;
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    @Override
    public String toString() {
        return amount + " " + currency();
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
