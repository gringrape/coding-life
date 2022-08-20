package krane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    void choose() {
        int[][] arrangement = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        Board board = new Board(arrangement);
        Basket basket = new Basket();

        Game game = new Game(board, basket);

        int[] lines = {1, 5, 3, 5, 1, 2, 1, 4};
        for (int line : lines) {
            game.handleChoose(line);
        }

        assertEquals(4, game.score());
    }
}
