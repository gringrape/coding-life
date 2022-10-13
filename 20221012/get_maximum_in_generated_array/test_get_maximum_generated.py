from math import floor


def get_maximum_generated(number):
    numbers = [0, 1]

    if number == 0:
        return numbers[0]

    if number == 1:
        return numbers[1]

    maximum = numbers[1]

    for i in range(2, number + 1):
        new_number = (
            numbers[floor(i / 2)]
            if i % 2 == 0
            else numbers[floor((i - 1) / 2)] + numbers[floor((i + 1) / 2)]
        )

        if new_number > maximum:
            maximum = new_number

        numbers.append(new_number)

    return maximum


def test_get_maximum_generated():
    assert get_maximum_generated(0) == 0
    assert get_maximum_generated(1) == 1
    assert get_maximum_generated(3) == 2
    assert get_maximum_generated(7) == 3
