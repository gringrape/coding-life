package trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterTest {
    @Test
    void addWord() {
        Letter letter = new Letter('.');

        letter.addWord("bad", 0);

        assertTrue(letter.match('b'));
    }

    @Test
    void search() {
        Letter letter = new Letter('.');

        letter.addWord("bad", 0);

        assertTrue(letter.search("bad", 0));
        assertFalse(letter.search("b", 0));
    }

    @Test
    void wildCardSearch() {
        Letter letter = new Letter('.');

        letter.addWord("bad", 0);

        assertTrue(letter.search(".ad", 0));
        assertTrue(letter.search(".a.", 0));
    }

    @Test
    void sample() {
        Letter letter = new Letter('.');

        letter.addWord("a", 0);

        assertFalse(letter.search("a.", 0));
    }

    @Test
    void sample2() {
        Letter letter = new Letter('.');

        letter.addWord("a", 0);
        letter.addWord("bat", 0);

        assertTrue(letter.search(".at", 0));
    }
}
