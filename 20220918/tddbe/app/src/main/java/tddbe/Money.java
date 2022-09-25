package tddbe;

public class Money {
    protected int amount;

    @Override
    public boolean equals(Object object) {
        Money other = (Money) object;
        return amount == other.amount;
    }
}
