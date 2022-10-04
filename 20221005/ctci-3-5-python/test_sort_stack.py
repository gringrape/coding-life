class Stack(list):
    def is_empty(self):
        return len(self) == 0

    def peek(self):
        return self[len(self) - 1]

    def push(self, item):
        self.append(item)


def sort_stack(numbers):
    stack = Stack(numbers)
    sorted_stack = Stack()

    while not stack.is_empty():
        number = stack.pop()

        pop_count = 0
        while not sorted_stack.is_empty() and number < sorted_stack.peek():
            stack.push(sorted_stack.pop())
            pop_count += 1

        sorted_stack.push(number)

        while pop_count > 0:
            sorted_stack.push(stack.pop())
            pop_count -= 1

    while not sorted_stack.is_empty():
        stack.push(sorted_stack.pop())

    return stack


def test_sort_stack():
    assert sort_stack([2]) == [2]
    assert sort_stack([3, 2]) == [3, 2]
    assert sort_stack([2, 3]) == [3, 2]
    assert sort_stack([3, 2, 4, 5]) == [5, 4, 3, 2]
    assert sort_stack([3, 2, 4, 5, 1]) == [5, 4, 3, 2, 1]
