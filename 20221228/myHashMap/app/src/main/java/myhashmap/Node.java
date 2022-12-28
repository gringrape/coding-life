package myhashmap;

public class Node<K, V> {
    private final K key;
    private final V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V value() {
        return value;
    }
}
