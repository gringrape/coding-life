from Node import Node


class Bucket:
    def __init__(self):
        self.head = Node()
        self.tail = Node()
        self.head.chain(self.tail)

    def push(self, key, value):
        if (node := self.find_node(key)):
            node.value = value
            return

        newest = Node(key, value)
        last = self.tail.prev
        last.chain(newest)
        newest.chain(self.tail)

    def find_node(self, key):
        current = self.head
        while current:
            if current.key == key:
                return current
            current = current.next

    def get_value(self, key):
        if not (node := self.find_node(key)):
            return None
        return node.value

    def remove(self, key):
        if not (node := self.find_node(key)):
            return
        node.prev.chain(node.next)
