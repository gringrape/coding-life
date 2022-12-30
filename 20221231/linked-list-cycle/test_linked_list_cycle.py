from pytest import fixture


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def next(node):
    if not node:
        return None
    return node.next


def hasCycle(head: ListNode):
    if not head:
        return False

    walker = head
    runner = next(head)

    while runner:
        if walker == runner:
            return True

        walker = next(walker)
        runner = next(next(runner))

    return False


def makeList(nodesValues, pos):
    nodes = [ListNode(value) for value in nodesValues]

    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]

    if pos >= 0 and pos < len(nodes):
        nodes[-1].next = nodes[pos]

    return nodes[0]


@fixture
def inputs():
    return [
        ([3, 2, 0, -4], 1, True),
        ([1, 2], 0, True),
        ([1], -1, False),
    ]


def test_hasCycle(inputs):
    for nodeValues, pos, expected in inputs:
        head = makeList(nodeValues, pos)
        assert hasCycle(head) == expected
