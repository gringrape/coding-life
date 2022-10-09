class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def has_no_child(self):
        return not self.left and not self.right


def check_height(root: Node, height=0) -> int:
    if not root:
        return height

    if root.has_no_child():
        return height + 1

    return max(
        check_height(root.left, height + 1), check_height(root.right, height + 1)
    )


def test_check_height():
    root = Node(1)
    assert check_height(root) == 1

    nodes = [Node(2), Node(3)]
    root.left = Node(2)

    assert check_height(root) == 2


def test_is_balanced():
    root = Node(1)
    nodes = [Node(2), Node(3)]
    root.left = Node(2)

    assert is_balanced(root) == True
