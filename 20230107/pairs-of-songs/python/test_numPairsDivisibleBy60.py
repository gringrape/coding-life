def numPairsDivisibleBy60(songs):
    return count_pairs(counts=count_remainder(songs))


def count_remainder(songs):
    remainders = [song % 60 for song in songs]
    counts = dict()
    for remainder in remainders:
        counts.setdefault(remainder, 0)
        counts[remainder] += 1
    return counts


def test_count_remainder():
    assert count_remainder([0, 10, 20, 10]) == {0: 1, 10: 2, 20: 1}


def count_pairs(counts):
    remainders = [0, 10, 20, 30]

    count = 0
    for remainder in remainders:
        count_a = counts.get(remainder, 0)
        count_b = counts.get(60 - remainder, 0)

        match remainder:
            case 0 | 30:
                count += count_a * (count_a - 1) // 2
            case _:
                count += count_a * count_b

    return count


def test_count_pairs():
    assert count_pairs({0: 2, 10: 2, 20: 3, 40: 5, 50: 3}) == 22
    assert count_pairs({0: 3}) == 3


def test_numPairsDivisibleBy60():
    assert numPairsDivisibleBy60([30, 20, 150, 100, 40]) == 3
    assert numPairsDivisibleBy60([60, 60, 60]) == 3
