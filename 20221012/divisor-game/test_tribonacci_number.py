def tribonacci_top_down(number, memo=[0, 1, 1]):
    if number >= len(memo):
        memo.append(
            tribonacci_top_down(number - 1)
            + tribonacci_top_down(number - 2)
            + tribonacci_top_down(number - 3)
        )

    return memo[number]


def tribonacci_bottom_up(number):
    initial_values = [0, 1, 1]

    if number < 3:
        return initial_values[number]

    a, b, c = initial_values

    for _ in range(number - 2):
        new_c = a + b + c

        a = b
        b = c
        c = new_c

    return c


solutions = [tribonacci_top_down, tribonacci_bottom_up]


def test_tribonacci():
    for tribonacci in solutions:
        assert tribonacci(0) == 0
        assert tribonacci(1) == 1
        assert tribonacci(2) == 1
        assert tribonacci(3) == 2
        assert tribonacci(25) == 1389537
