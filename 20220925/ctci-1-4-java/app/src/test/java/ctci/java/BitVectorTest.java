package ctci.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitVectorTest {
    @Test
    void toggle() {
        BitVector vector = new BitVector();

        assertEquals(vector.get(2), 0);

        vector.toggle(2);

        assertEquals(vector.get(2), 1);

        vector.toggle(2);

        assertEquals(vector.get(2), 0);
    }

    @Test
    void sumOfDigits() {
        BitVector vector = new BitVector();

        vector.toggle(0);

        assertEquals(1, vector.sumOfDigits());

        vector.toggle(1);

        assertEquals(2, vector.sumOfDigits());

        vector.toggle(2);
        vector.toggle(3);
        vector.toggle(4);

        assertEquals(5, vector.sumOfDigits());
    }

    @Test
    void checkExactlyOneBitSet() {
        BitVector vector = new BitVector();

        assertFalse(vector.checkExactlyOneBitSet());

        vector.toggle(1);

        assertTrue(vector.checkExactlyOneBitSet());

        vector.toggle(3);

        assertFalse(vector.checkExactlyOneBitSet());
    }
}
