from math import inf


def solution(n, wires):
    towers = {i: Tower(i) for i in range(1, n + 1)}

    for a, b in wires:
        first_tower, second_tower = towers[a], towers[b]

        first_tower.connect(second_tower)

    minimum_difference = inf

    for a, b in wires:
        first_tower, second_tower = towers[a], towers[b]
        first_tower.disconnect(second_tower)

        difference = abs(
            count_network_towers(first_tower) - count_network_towers(second_tower)
        )

        if difference < minimum_difference:
            minimum_difference = difference

        first_tower.connect(second_tower)

    return minimum_difference


def test_solution():
    n = 9
    wires = [[1, 3], [2, 3], [3, 4], [4, 5], [4, 6], [4, 7], [7, 8], [7, 9]]

    assert solution(n, wires) == 3


class Tower:
    def __init__(self, value):
        self.value = value
        self.neighbors = []

    def connect(self, neighbor):
        self.neighbors.append(neighbor)
        neighbor.neighbors.append(self)

    def disconnect(self, neighbor):
        self.neighbors.remove(neighbor)
        neighbor.neighbors.remove(self)


def count_network_towers(initial_tower):
    visited = set()

    def count(tower):
        if tower in visited:
            return 0

        visited.add(tower)

        return 1 + sum(count(neighbor) for neighbor in tower.neighbors)

    return count(initial_tower)


def test_count_network_towers():
    initial_tower = Tower(1)
    neighbor_towers = [Tower(2), Tower(3), Tower(4)]

    for neighbor_tower in neighbor_towers:
        initial_tower.connect(neighbor_tower)

    assert count_network_towers(initial_tower) == 1 + len(neighbor_towers)
