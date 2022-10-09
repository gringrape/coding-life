package tddbe;

public class Pair {
    private final String from;
    private final String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object object) {
        Pair other = (Pair) object;
        return from.equals(other.from) && to.equals(other.to);
    }

    public int hashCode() {
        return 0;
    }
}
