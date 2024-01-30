package tdd;

public class Sum implements Expression {
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        return new Money(augend.reduce(bank, to).amount + addend.reduce(bank, to).amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return null;
    }

    @Override
    public Money times(int multiplier) {
        return null;
    }
}
