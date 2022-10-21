class DiscountItems:
    def __init__(self):
        self.items = dict()

    def push(self, item):
        if item not in self.items:
            self.items[item] = 0
        self.items[item] += 1

    def pop(self, item):
        self.items[item] -= 1
        if self.items[item] == 0:
            self.items.pop(item)

    def count(self, item):
        return self.items.get(item, 0)


def count_sign_up_days(want, number, discount):
    wanted_items = {want[i]: number[i] for i in range(len(want))}

    discount_items = DiscountItems()
    for i in range(10):
        discount_items.push(discount[i])

    signup_days_count = 0

    if all(count <= discount_items.count(item) for item, count in wanted_items.items()):
        signup_days_count = 1

    for day in range(1, len(discount) - 10 + 1):
        discount_items.push(discount[day + 10 - 1])
        discount_items.pop(discount[day - 1])
        if all(
            count <= discount_items.count(item) for item, count in wanted_items.items()
        ):
            signup_days_count += 1

    return signup_days_count


def test_count_sign_up_days():
    want = ["banana", "apple", "rice", "pork", "pot"]
    number = [3, 2, 2, 2, 1]
    discount = [
        "chicken",
        "apple",
        "apple",
        "banana",
        "rice",
        "apple",
        "pork",
        "banana",
        "pork",
        "rice",
        "pot",
        "banana",
        "apple",
        "banana",
    ]
    result = 3

    assert count_sign_up_days(want, number, discount) == result
