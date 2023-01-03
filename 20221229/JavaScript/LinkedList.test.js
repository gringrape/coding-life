import LinkedList from './LinkedList';

import Node from './Node';

describe('LinkedList', () => {
  const nodes = [
    new Node({ key: 1, value: 1 }),
    new Node({ key: 2, value: 2 }),
    new Node({ key: 3, value: 3 }),
  ];

  test('addFirst', () => {
    const list = new LinkedList();

    list.addFirst(nodes[0]);
    list.addFirst(nodes[1]);

    expect(list.first()).toEqual(nodes[1]);
    expect(list.last()).toEqual(nodes[0]);
  });

  test('removeLast', () => {
    const list = new LinkedList();

    nodes.forEach((node) => {
      list.addFirst(node);
    });

    nodes.forEach((node) => {
      const removed = list.removeLast();

      expect(removed).toEqual(node);
    });
  });
});
