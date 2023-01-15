def maxSequenceSum(numbers):
    maxSum = numbers[0]
    ans = maxSum

    for i in range(1, len(numbers)):
        maxSum = max(numbers[i] + maxSum, numbers[i])
        ans = max(maxSum, ans)

    return ans


def test_maxSequenceSum():
    assert maxSequenceSum([10, -4, 3, 1, 5, 6, -35, 12, 21, -1]) == 33
