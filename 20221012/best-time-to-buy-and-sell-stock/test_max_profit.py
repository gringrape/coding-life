from math import inf


def max_profit(prices):
    maximum = prices[0]
    minimum = prices[0]
    gap = 0

    for price in prices[1:]:
        if price > maximum:
            maximum = price
            new_gap = maximum - minimum
            gap = new_gap if new_gap > gap else gap

        if price < minimum:
            maximum = price
            minimum = price

    return gap


def test_max_profit():
    assert max_profit([7, 1, 5, 3, 6, 4]) == 5
    assert max_profit([3, 2, 6, 5, 0, 3]) == 4
