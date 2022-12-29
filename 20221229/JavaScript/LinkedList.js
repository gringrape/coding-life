import Node from './Node';

export default class LinkedList {
  constructor() {
    this.head = new Node({});
    this.tail = new Node({});
    this.head.chain(this.tail);
  }

  addFirst(newest) {
    const first = this.head.next;
    this.head.chain(newest);
    newest.chain(first);
  }

  removeLast() {
    const last = this.tail.previous;
    this.remove(last);
    return last;
  }

  remove(node) {
    if (this.isEmpty()) {
      return;
    }
    const { previous, next } = node;
    previous.chain(next);
  }

  isEmpty() {
    return this.head.next === this.tail;
  }

  first() {
    return this.head.next;
  }

  last() {
    return this.tail.previous;
  }
}
