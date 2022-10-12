package fibonacci;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciBottomUpTest {
    int fibonacci(int number) {
        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        int secondLast = 0;
        int last = 1;

        for (int i = 0; i < number - 2; i++) {
            int current = last + secondLast;
            secondLast = last;
            last = current;
        }

        return last + secondLast;
    }

    @Test
    void testFibonacci() {
        assertThat(fibonacci(0)).isEqualTo(0);
        assertThat(fibonacci(1)).isEqualTo(1);
        assertThat(fibonacci(2)).isEqualTo(1);
        assertThat(fibonacci(10)).isEqualTo(55);
    }
}
