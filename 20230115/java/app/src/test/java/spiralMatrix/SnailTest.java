package spiralMatrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnailTest {
    private int[][] map;
    private int M;

    @BeforeEach
    void setup() {
        map = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        M = map[0].length;
    }

    @Test
    void advance() {
        Snail snail = new Snail(map);

        assertEquals(List.of(), snail.path());

        for (int i = 0; i < M; i += 1) {
            snail.advance();
        }

        assertEquals(List.of(1, 2, 3), snail.path());
    }

    @Test
    void turn() {
        Snail snail = new Snail(map);

        assertEquals(List.of(), snail.path());

        for (int i = 0; i < 4; i += 1) {
            snail.advance();
        }

        assertEquals(List.of(1, 2, 3, 6), snail.path());

        snail.advance();
        snail.advance();

        assertEquals(List.of(1, 2, 3, 6, 9, 8), snail.path());

        snail.advance();
        snail.advance();

        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4), snail.path());
    }

    @Test
    void recordVisited() {
        Snail snail = new Snail(map);

        assertEquals(List.of(), snail.path());

        for (int i = 0; i < 9; i += 1) {
            snail.advance();
        }

        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), snail.path());
    }
}
