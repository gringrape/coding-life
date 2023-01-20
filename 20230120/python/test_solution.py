from itertools import dropwhile
from collections import Counter


class Box:
    def __init__(self, capacity):
        self.tangerines = dict()
        self.capacity = capacity

    def put(self, weight, count):
        if weight not in self.tangerines:
            self.tangerines[weight] = 0
        self.tangerines[weight] += count
        self.capacity -= count

    def hasCapacity(self):
        return self.capacity > 0

    def distinctWeightCount(self):
        return len(self.tangerines)


def solution(k, tangerine):
    box = Box(capacity=k)

    for weight, count in Counter(tangerine).most_common():
        if not box.hasCapacity():
            break
        box.put(weight, count)

    return box.distinctWeightCount()


def test_sample():
    assert solution(
        k=6,
        tangerine=[1, 3, 2, 5, 4, 5, 2, 3]
    ) == 3
    assert solution(
        k=4,
        tangerine=[1, 3, 2, 5, 4, 5, 2, 3]
    ) == 2
    assert solution(
        k=2,
        tangerine=[1, 1, 1, 1, 2, 2, 2, 3]
    ) == 1
