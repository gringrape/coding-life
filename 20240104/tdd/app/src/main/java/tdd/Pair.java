package tdd;

public class Pair {
    private String from;
    private String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        Pair other = (Pair) object;
        return from.equals(other.from) && to.equals(other.to);
    }
}
