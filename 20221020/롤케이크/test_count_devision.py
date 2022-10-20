def count_devision(toppings):
    count = 0

    topping_counts_left = dict()
    topping_counts_right = dict()

    for topping in toppings:
        if topping not in topping_counts_right:
            topping_counts_right[topping] = 0
        topping_counts_right[topping] += 1

    for topping in toppings:
        if topping not in topping_counts_left:
            topping_counts_left[topping] = 0
        topping_counts_left[topping] += 1

        topping_counts_right[topping] -= 1
        if topping_counts_right[topping] == 0:
            topping_counts_right.pop(topping)

        if len(topping_counts_left) == len(topping_counts_right):
            count += 1

    return count


def test_count_devision():
    assert count_devision([1, 2, 1, 3, 1, 4, 1, 2]) == 2
