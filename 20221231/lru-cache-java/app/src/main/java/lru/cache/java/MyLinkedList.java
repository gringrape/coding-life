package lru.cache.java;

public class MyLinkedList {
    private final Node head;
    private final Node tail;

    public MyLinkedList() {
        head = new Node(-100, -100);
        tail = new Node(-100, -100);
        head.chain(tail);
    }

    public Node removeLast() {
        Node last = tail.previous();
        remove(last);
        return last;
    }

    public void addFirst(Node node) {
        node.chain(head.next());
        head.chain(node);
    }

    public void remove(Node node) {
        if (isEmpty()) {
            return;
        }
        Node previous = node.previous();
        Node next = node.next();
        previous.chain(next);
    }

    private boolean isEmpty() {
        return head.next() == tail;
    }
}
