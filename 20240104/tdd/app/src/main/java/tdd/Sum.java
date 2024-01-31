package tdd;

public class Sum implements Expression {
    public Expression augend;
    public Expression addend;

    // Pattern => 자식들에 동일한 연산을 해줌. => composite pattern
    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        return new Money(augend.reduce(bank, to).amount + addend.reduce(bank, to).amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(
                augend.times(multiplier),
                addend.times(multiplier)
        );
    }
}
