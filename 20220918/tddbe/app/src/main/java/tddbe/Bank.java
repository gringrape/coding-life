package tddbe;

import java.util.Hashtable;

public class Bank {
    private Hashtable<Pair, Integer> rates;

    public Bank() {
        rates = new Hashtable<>();
    }

    public Money reduce(Expression expression, String to) {
        return expression.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return rates.get(new Pair(from, to));
    }
}
