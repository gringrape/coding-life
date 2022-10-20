def count_three_musketeers(numbers, musketeers=[]):
    if len(musketeers) == 3 and sum(musketeers) == 0:
        return 1

    if not numbers:
        return 0

    return sum(
        count_three_musketeers(
            numbers=numbers[index + 1 :],
            musketeers=[*musketeers, numbers[index]],
        )
        for index, number in enumerate(numbers)
    )


def test_count_three_musketeers():
    assert count_three_musketeers([-2, 3, 0, 2, -5]) == 2
    assert count_three_musketeers([-3, -2, -1, 0, 1, 2, 3]) == 5
    assert count_three_musketeers([-1, 1, -1, 1]) == 0
