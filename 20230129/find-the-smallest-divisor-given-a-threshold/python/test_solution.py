# 문제
# - 구하는 것 - smallest divisor 찾기
# - 조건 - nums 를 divisor 로 나누어서 합한 다음 올림한 값 <= threshold

from math import ceil


def binarySearchSmallest(low, high, predicate):
    if low >= high:
        return low

    mid = (low + high) // 2

    if predicate(mid):
        return binarySearchSmallest(low, mid, predicate)

    return binarySearchSmallest(mid + 1, high, predicate)


def smallestDivisor(nums, threshold):
    def isRightDivisor(divisor):
        return sum(ceil(num / divisor) for num in nums) <= threshold

    return binarySearchSmallest(
        low=1,
        high=10**6,
        predicate=isRightDivisor
    )


def test_solution():
    assert smallestDivisor(
        nums=[1, 2, 5, 9], threshold=6
    ) == 5
