/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gringrape.mineSweeper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    @Test
    void selectMineSpotDestroyBoard() {
        Board board = new Board(); // 생성시에 지뢰 위치 입력.

        assertThat(board.isDestroyed()).isFalse();

        board.select(0, 0);

        assertThat(board.isDestroyed()).isTrue();
    }
}
