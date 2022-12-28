package myhashmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {
    private final Node<K, V>[] table;

    public HashMap() {
        int initialCapacity = 100;
        table = new Node[initialCapacity];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = table[tableIndex(key)];
        return node.value();
    }

    private int tableIndex(Object key) {
        return key.hashCode() % 31;
    }

    @Override
    public V put(K key, V value) {
        int index = tableIndex(key);
        table[index] = new Node<>(key, value);
        return value;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
