import LinkedList from './LinkedList';
import Node from './Node';

export default class LRUCache {
  static NOT_EXIST = -1;

  constructor(capacity) {
    this.capacity = capacity;
    this.map = new Map();
    this.list = new LinkedList();
  }

  put(key, value) {
    if (this.containsNode(key)) {
      this.update(key, value);
      return;
    }

    if (this.isFull()) {
      this.evictLeastUsed();
    }
    this.addNode({ key, value });
  }

  containsNode(key) {
    return this.map.has(key);
  }

  update(key, value) {
    const node = this.getNode(key);
    node.update({ value });

    this.updatePriority(node);
  }

  getNode(key) {
    return this.map.get(key);
  }

  updatePriority(node) {
    this.list.remove(node);
    this.list.addFirst(node);
  }

  isFull() {
    return this.capacity === this.map.size;
  }

  evictLeastUsed() {
    const leastUsed = this.list.removeLast();
    this.map.delete(leastUsed.key);
  }

  addNode({ key, value }) {
    const newest = new Node({ key, value });
    this.list.addFirst(newest);
    this.map.set(key, newest);
  }

  get(key) {
    if (!this.containsNode(key)) {
      return LRUCache.NOT_EXIST;
    }

    const node = this.getNode(key);
    this.updatePriority(node);
    return node.value;
  }
}
