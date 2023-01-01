package lru.cache.java;

public class Node {
    private final int key;
    private int value;
    private Node previous;
    private Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int value() {
        return value;
    }

    public int key() {
        return key;
    }

    public Node next() {
        return next;
    }

    public void chain(Node node) {
        if (node == null) {
            return;
        }
        this.setNext(node);
        node.setPrevious(this);
    }

    private void setPrevious(Node node) {
        previous = node;
    }

    private void setNext(Node node) {
        next = node;
    }

    public Node previous() {
        return previous;
    }

    public void update(int value) {
        this.value = value;
    }
}
