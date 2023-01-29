package trie;

public class WordDictionary {
    private final Letter root = new Letter('.');

    public void addWord(String word) {
        root.addWord(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }
}
