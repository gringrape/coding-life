package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Snail {
    private final List<Integer> path;
    private final int[][] map;
    private int posX;
    private int posY;
    private int dx;
    private int dy;
    private int[][] record;
    private int M;
    private int N;

    public Snail(int[][] map) {
        this.map = map;
        M = map.length;
        N = map[0].length;
        this.record = new int[M][N];
        path = new ArrayList<>();
        posX = -1;
        posY = 0;
        dx = 1;
        dy = 0;
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
