package tdd;

public abstract class Money {
    protected int amount;

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Money franc(int amount) {
        return new Franc(amount);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: currency 개념 도입
        Money money = (Money) object;
        return amount == money.amount
                && getClass().equals(object.getClass());
    }

    abstract public Money times(int multiplier);
}
