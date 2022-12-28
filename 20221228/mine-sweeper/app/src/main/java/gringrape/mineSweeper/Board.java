package gringrape.mineSweeper;

public class Board {
    private static final int MINE = 1;
    private static final int BLANK = 0;
    private static final int CHECKED = 2;
    private final int size;
    private boolean destroyed = false;
    private boolean searching = true;
    private final int[][] board;

    public Board(int size) {
        this.size = size;

        board = new int[][]{
                {MINE, BLANK, BLANK, BLANK, BLANK},
                {BLANK, BLANK, BLANK, BLANK, BLANK},
                {BLANK, BLANK, BLANK, BLANK, BLANK},
                {BLANK, BLANK, BLANK, BLANK, BLANK},
                {BLANK, BLANK, BLANK, BLANK, BLANK},
        };
    }

    public void select(int row, int column) {
        if (board[row][column] == MINE) {
            destroyed = true;
            searching = false;
        }

        board[row][column] = CHECKED;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isSearching() {
        return searching;
    }

    public String[][] toArray() {
        String[][] representation = {
                {"?", "?", "?", "?", "?"},
                {"?", "?", "?", "?", "?"},
                {"?", "?", "?", "?", "?"},
                {"?", "?", "?", "?", "?"},
                {"?", "?", "?", "?", "?"},
        };

        for (int row = 0; row < size; row += 1) {
            for (int column = 0; column < size; column += 1) {
                if (board[row][column] == CHECKED) {
                    representation[row][column] = "!";
                }
            }
        }

        return representation;
    }
}
