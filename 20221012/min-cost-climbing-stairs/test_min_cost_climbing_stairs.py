def min_cost_climbing_stairs_top_down(costs):
    min_costs = {}

    def calculate_from(step):
        if step > len(costs) - 1:
            return 0

        if step not in min_costs:
            min_costs[step] = costs[step] + min(
                calculate_from(step=step + 1), calculate_from(step=step + 2)
            )

        return min_costs[step]

    return min(calculate_from(step=0), calculate_from(step=1))


def min_cost_climbing_stairs_bottom_up(costs):
    min_costs_reversed = [costs[-1], costs[-2]]

    costs_reversed = list(reversed(costs))

    for i in range(2, len(costs)):
        min_costs_reversed.append(
            costs_reversed[i]
            + min(min_costs_reversed[i - 1], min_costs_reversed[i - 2])
        )

    min_costs = list(reversed(min_costs_reversed))

    return min(min_costs[0], min_costs[1])


def min_cost_climbing_stairs_bottom_up_2(costs):
    a, b = (costs[-1], costs[-2])

    costs_reversed = list(reversed(costs))

    for i in range(2, len(costs)):
        new_b = costs_reversed[i] + min(a, b)

        a = b
        b = new_b

    return min(a, b)


solutions = [
    min_cost_climbing_stairs_top_down,
    min_cost_climbing_stairs_bottom_up,
    min_cost_climbing_stairs_bottom_up_2,
]


def test_min_cost_climbing_stairs():
    for min_cost_climbing_stairs in solutions:
        assert min_cost_climbing_stairs([10, 15, 20]) == 15
        assert min_cost_climbing_stairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1]) == 6
