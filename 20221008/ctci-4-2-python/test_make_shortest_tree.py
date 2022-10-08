from math import floor


class TreeNode:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def sorted_array_to_binary_search_tree(numbers):
    if not numbers:
        return None

    middle_index = floor(len(numbers) / 2)
    node = TreeNode(numbers[middle_index])

    node.left = sorted_array_to_binary_search_tree(numbers[:middle_index])
    node.right = sorted_array_to_binary_search_tree(numbers[middle_index + 1 :])

    return node


def test_sorted_array_to_binary_search_tree():
    root = sorted_array_to_binary_search_tree([-10, -3, 0, 5, 9])

    assert root.value == 0
    assert root.left.value == -3
    assert root.left.left.value == -10
    assert root.right.value == 9
    assert root.right.left.value == 5
