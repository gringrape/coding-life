package lru.cache.java;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> nodes;
    private final MyLinkedList nodesWithPriority;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodes = new HashMap<>();
        nodesWithPriority = new MyLinkedList();
    }

    public int get(int key) {
        if (!nodes.containsKey(key)) {
            return -1;
        }

        Node node = nodes.get(key);
        updatePriority(node);
        return node.value();
    }

    private void updatePriority(Node node) {
        nodesWithPriority.remove(node);
        nodesWithPriority.addFirst(node);
    }

    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            update(node, value);
            return;
        }

        if (isFull()) {
            evictLeastUsedNode();
        }
        Node newest = new Node(key, value);
        nodesWithPriority.addFirst(newest);
        nodes.put(key, newest);
    }

    private void update(Node node, int value) {
        node.update(value);
        updatePriority(node);
    }

    private void evictLeastUsedNode() {
        Node leastUsed = nodesWithPriority.removeLast();
        nodes.remove(leastUsed.key());
    }

    public boolean isFull() {
        return capacity == nodes.size();
    }
}
