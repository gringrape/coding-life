/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package fibonacci;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {
    int fibonacci(int number) {
        return fibonacci(number, new int[number + 1]);
    }

    int fibonacci(int number, int[] memo) {
        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        if (memo[number] == 0) {
            memo[number] = (
                    fibonacci(number - 1, memo) + fibonacci(number - 2, memo)
            );
        }

        return memo[number];
    }

    @Test
    void testFibonacci() {
        assertThat(fibonacci(0)).isEqualTo(0);
        assertThat(fibonacci(1)).isEqualTo(1);
        assertThat(fibonacci(2)).isEqualTo(1);
        assertThat(fibonacci(10)).isEqualTo(55);
    }
}
