from collections import Counter


def topKFrequent_Counter(nums, k):
    return [number for number, count in Counter(nums).most_common(k)]


def topKFrequent_countAndSort(nums, k):
    counts = {}

    for number in nums:
        if not number in counts:
            counts[number] = 0
        counts[number] += 1

    numbersWithCount = list(counts.items())
    return [
        number for number, _ in sorted(numbersWithCount, key=lambda x: x[1], reverse=True)
    ][:k]


solutions = [
    topKFrequent_Counter,
    topKFrequent_countAndSort
]


def test_topKFrequent():
    for solution in solutions:
        assert solution(nums=[1, 1, 1, 2, 2, 3], k=2) == [1, 2]
        assert solution(nums=[4, 1, -1, 2, -1, 2, 3], k=2) == [-1, 2]
