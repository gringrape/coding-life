package trie;

import java.util.HashMap;
import java.util.Map;

public class Letter {
    private static final char WILD_CARD = '.';
    private final Map<Character, Letter> nextLetters = new HashMap<>();
    private boolean isLast = false;

    public Letter(char letter) {
    }

    public void addWord(String word, int index) {
        if (index >= word.length()) {
            isLast = true;
            return;
        }

        char letter = word.charAt(index);
        if (match(letter)) {
            next(letter).addWord(word, index + 1);
            return;
        }

        Letter firstLetter = appendNext(letter);
        firstLetter.addWord(word, index + 1);
    }

    private Letter appendNext(char letterString) {
        Letter firstLetter = new Letter(letterString);
        nextLetters.put(letterString, firstLetter);
        return firstLetter;
    }

    public boolean match(char nextLetter) {
        return nextLetters.containsKey(nextLetter);
    }

    public boolean search(String word, int index) {
        if (index >= word.length()) {
            return this.isLastLetter();
        }

        char character = word.charAt(index);
        if (character == WILD_CARD) {
            return searchEveryNext(word, index);
        }

        if (!this.match(character)) {
            return false;
        }

        return next(character).search(word, index + 1);
    }

    private boolean hasAnyNext() {
        return !nextLetters.isEmpty();
    }

    private boolean searchEveryNext(String word, int index) {
        if (!hasAnyNext()) {
            return false;
        }

        return nextLetters.values().stream()
                .anyMatch(letter -> letter.search(word, index + 1));
    }

    private Letter next(char letter) {
        return nextLetters.get(letter);
    }

    private boolean isLastLetter() {
        return isLast;
    }
}
