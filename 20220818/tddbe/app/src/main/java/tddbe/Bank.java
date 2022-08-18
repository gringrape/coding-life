package tddbe;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Pair, Integer> rates;

    Bank() {
        rates = new HashMap<>();
    }

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int ratio) {
        rates.put(new Pair(from, to), ratio);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }

        return rates.get(new Pair(from, to));
    }

    private class Pair {
        private String first;
        private String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public int hashCode() {
            return 0;
        }

        @Override
        public boolean equals(Object object) {
            Pair other = (Pair) object;
            return first.equals(other.first) && second.equals(other.second);
        }
    }
}
