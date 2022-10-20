def find_pair_combination(x, y):
    x_digits = {str(k): 0 for k in range(10)}
    y_digits = {str(k): 0 for k in range(10)}

    for i in range(len(x)):
        x_digits[x[i]] += 1

    for i in range(len(y)):
        y_digits[y[i]] += 1

    common_numbers_count = {
        key: min(x_digits[key], y_digits[key]) for key in x_digits.keys()
    }

    common_numbers = []

    for key, count in sorted(common_numbers_count.items(), reverse=True):
        for _ in range(count):
            common_numbers.append(key)

    result = "".join(common_numbers)

    if not result:
        return "-1"

    if result[0] == "0":
        return "0"

    return result


def test_find_pair_combination():
    assert find_pair_combination("5525", "1255") == "552"
    assert find_pair_combination("12321", "42531") == "321"
    assert find_pair_combination("100", "123450") == "10"
    assert find_pair_combination("100", "203045") == "0"
    assert find_pair_combination("100", "2345") == "-1"
