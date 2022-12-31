package lru.cache.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyLinkedListTest {
    @Test
    void removeLast() {
        MyLinkedList list = new MyLinkedList();

        list.addFirst(new Node(1, 1));
        list.addFirst(new Node(2, 2));
        list.addFirst(new Node(3, 3));

        Node last = list.removeLast();

        assertThat(last.key()).isEqualTo(1);
    }

    @Test
    void removeWithEmptyList() {
        MyLinkedList list = new MyLinkedList();

        list.remove(new Node(1, 1));
    }
}
