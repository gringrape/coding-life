package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Snail {
    private final List<Integer> path = new ArrayList<>();
    private final int[][] record;

    private final int[][] map;
    private final int MAP_HEIGHT;
    private final int MAP_WIDTH;

    private int posX = -1;
    private int posY = 0;

    private int dx = 1;
    private int dy = 0;

    public Snail(int[][] map) {
        this.map = map;
        MAP_HEIGHT = map.length;
        MAP_WIDTH = map[0].length;

        this.record = new int[MAP_HEIGHT][MAP_WIDTH];
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
        return x < 0 || x >= MAP_WIDTH || y < 0 || y >= MAP_HEIGHT;
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
