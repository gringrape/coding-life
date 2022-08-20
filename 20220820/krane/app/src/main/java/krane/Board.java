package krane;

import java.util.Arrays;

public class Board {
    final int NOT_FOUND = -100;
    int[][] arrangement;
    int size;

    public Board(int[][] arrangement) {
        this.arrangement = arrangement;
        size = arrangement.length;
    }

    public Integer pick(int line) {
        int slot = locate(line);

        if (slot == NOT_FOUND) {
            return null;
        }

        return take(line, slot);
    }

    private int take(int line, int slot) {
        int column = line - 1;
        int row = slot - 1;

        int doll = arrangement[row][column];
        arrangement[row][column] = 0;

        return doll;
    }

    private int locate(int line) {
        int column = line - 1;

        for (int row = 0; row < size; row++) {
            if (arrangement[row][column] != 0) {
                return row + 1;
            }
        }

        return NOT_FOUND;
    }
}
