/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitvector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitVectorTest {
    boolean hasDuplicateLettersBit(String string) {
        int checker = 0;
        for (int i = 0; i < string.length(); i += 1) {
            char l = string.charAt(i);
            int index = l - 'a';
            if ((checker & (1 << index)) > 0) {
                return true;
            }
            checker |= (1 << index);
        }
        return false;
    }

    boolean hasDuplicateLettersArray(String string) {
        boolean[] checker = new boolean[string.length()];
        for (int i = 0; i < string.length(); i += 1) {
            char l = string.charAt(i);
            int index = l - 'a';
            if (checker[index]) {
                return true;
            }
            checker[index] = true;
        }
        return false;
    }

    @Test
    void testHasDuplicateLettersBit() {
        assertTrue(hasDuplicateLettersBit("abca"));
        assertTrue(hasDuplicateLettersBit("abcdeee"));
        assertFalse(hasDuplicateLettersBit("abcd"));
    }

    @Test
    void testHasDuplicateLettersArray() {
        assertTrue(hasDuplicateLettersArray("abca"));
        assertTrue(hasDuplicateLettersArray("abcdeee"));
        assertFalse(hasDuplicateLettersArray("abcd"));
    }
}
