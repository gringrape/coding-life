/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package validpath.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void validPathWithQuickFindSamples() {
        Solution solution = new Solution(new QuickFindDisjointSet());

        assertThat(solution.validPath(
                3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, 0, 2
        )).isTrue();

        assertThat(solution.validPath(
                6, new int[][] {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5
        )).isFalse();
    }

    @Test
    void validPathWithQuickUnionSamples() {
        Solution solution = new Solution(new QuickUnionDisjointSet());

        assertThat(solution.validPath(
                3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, 0, 2
        )).isTrue();

        assertThat(solution.validPath(
                6, new int[][] {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5
        )).isFalse();
    }

    @Test
    void validPathWithCompressedPathSamples() {
        Solution solution = new Solution(new CompressedPathDisjointSet());

        assertThat(solution.validPath(
                3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, 0, 2
        )).isTrue();

        assertThat(solution.validPath(
                6, new int[][] {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5
        )).isFalse();
    }
}