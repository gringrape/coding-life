package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Snail {
    private final int[][] map;
    private final int M;
    private final int N;
    private final List<Integer> path = new ArrayList<>();
    private final int[][] record;
    private int posX = -1;
    private int posY = 0;
    private int dx = 1;
    private int dy = 0;

    public Snail(int[][] map) {
        this.map = map;
        M = map.length;
        N = map[0].length;

        this.record = new int[M][N];
    }

    public List<Integer> path() {
        return path;
    }

    public void advance() {
        if (isAheadBlocked()) {
            turn();
        }

        goStraight();
        record();
    }

    private boolean isAheadBlocked() {
        int aheadX = posX + dx;
        int aheadY = posY + dy;
        return outOfBound(aheadX, aheadY) || isRecorded(aheadX, aheadY);
    }

    private boolean outOfBound(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    private boolean isRecorded(int x, int y) {
        return record[y][x] == 1;
    }

    private void turn() {
        int temp = dx;
        dx = -dy;
        dy = temp;
    }

    private void goStraight() {
        posX += dx;
        posY += dy;
    }

    private boolean record() {
        record[posY][posX] = 1;
        int value = map[posY][posX];
        return path.add(value);
    }
}
