class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def level_order(root: TreeNode):
    result = []

    def traverse(node, depth):
        if not node:
            return

        if len(result) <= depth:
            result.append([])

        result[depth].append(node.val)

        traverse(node=node.left, depth=depth + 1)
        traverse(node=node.right, depth=depth + 1)

    traverse(node=root, depth=0)

    return result


def test_level_order_simple():
    root = TreeNode(1)
    assert level_order(root) == [[1]]


def test_level_order_bit_complex():
    root = TreeNode(3)
    root.left = TreeNode(9)

    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)

    assert level_order(root) == [[3], [9, 20], [15, 7]]
