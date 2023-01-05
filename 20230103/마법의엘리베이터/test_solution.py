from math import log, floor


def solution_from_top(storey):
    if storey == 0:
        return 0

    power = floor(log(storey, 10))

    upper = 10 ** (power + 1)
    lower = 10 ** power

    next_storey = storey - lower \
        if storey < (upper + lower) / 2 \
        else abs(storey - upper)

    return 1 + solution_from_top(next_storey)


def solution_from_bottom(storey):
    if storey < 10:
        return min(11 - storey, storey)

    last = storey % 10

    return min(last + solution_from_bottom(storey // 10), (10 - last) + solution_from_bottom(storey // 10 + 1))


solutions = [solution_from_top, solution_from_bottom]


def test_sample():
    for solution in solutions:
        assert solution(storey=16) == 6
        assert solution(storey=2554) == 16
