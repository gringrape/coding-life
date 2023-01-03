export default class Node {
  constructor({ key, value }) {
    this.key = key;
    this.value = value;
    this.previous = null;
    this.next = null;
  }

  chain(node) {
    node.setPrevious(this);
    this.setNext(node);
  }

  update({ value }) {
    this.value = value;
  }

  setPrevious(node) {
    this.previous = node;
  }

  setNext(node) {
    this.next = node;
  }
}
