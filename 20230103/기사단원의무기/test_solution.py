def solution(number, limit, power):
    powers = [power_of(knight)
              for knight in range(1, number + 1)]
    weights = restrict(powers=powers, limit=limit, alternative=power)
    return sum(weights)


def restrict(powers, limit, alternative):
    return [
        power if power <= limit else alternative
        for power in powers
    ]


def power_of(knight):
    factor_count = sum(
        1 if i == knight / i else 2
        for i in range(1, int(knight ** 0.5) + 1) if knight % i == 0
    )
    return factor_count


def test_sample():
    assert solution(number=5, limit=3, power=2) == 10
    assert solution(number=10, limit=3, power=2) == 21
