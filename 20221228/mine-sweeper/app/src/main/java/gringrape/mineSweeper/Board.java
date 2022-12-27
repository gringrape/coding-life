package gringrape.mineSweeper;

public class Board {
    private boolean destroyed = false;
    private boolean searching = true;

    public void select(int row, int column) {
        destroyed = true;
        searching = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isSearching() {
        return searching;
    }
}
