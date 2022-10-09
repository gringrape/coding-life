from math import inf


class TreeNode:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def validate_bst(root, minimum_limit=-inf, maximum_limit=inf):
    if not root:
        return True

    return (
        (root.value >= minimum_limit and root.value <= maximum_limit)
        and validate_bst(
            root=root.left, minimum_limit=minimum_limit, maximum_limit=root.value
        )
        and validate_bst(
            root=root.right, minimum_limit=root.value, maximum_limit=maximum_limit
        )
    )


def validate_bst_by_making_ascending_list(root):
    numbers = []

    def traverse(root):
        if not root:
            return

        traverse(root.left)
        numbers.append(root.value)
        traverse(root.right)

    traverse(root)

    return all(numbers[i] <= numbers[i + 1] for i in range(len(numbers) - 1))


solutions = [validate_bst, validate_bst_by_making_ascending_list]


def test_validate_bst_valid_case():
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)

    for validate_bst in solutions:
        assert validate_bst(root) == True


def test_validate_bst_invalid_case():
    root = TreeNode(2)
    root.left = TreeNode(3)
    root.right = TreeNode(1)

    for validate_bst in solutions:
        assert validate_bst(root) == False


def test_validate_bst_sample():
    root = TreeNode(2)
    root.left = TreeNode(3)
    root.right = TreeNode(1)

    for validate_bst in solutions:
        assert validate_bst(root) == False
