package tddbe;

public class Money extends Expression {
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

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    public Money plus(Money addend) {
        return new Money(amount + addend.amount, currency);
    }
}
