def solution(n, roads, sources, destination):
    neighbors = {i: [] for i in range(1, n + 1)}

    for start, end in roads:
        neighbors[start].append(end)
        neighbors[end].append(start)

    distances = {}
    visited = set()

    queue = [(destination, 0)]
    visited.add(destination)
    while queue:
        node, distance = queue.pop(0)
        distances[node] = distance
        for neighbor in neighbors[node]:
            if neighbor not in visited:
                queue.append((neighbor, distance + 1))
                visited.add(neighbor)

    return [distances[i] if i in distances else -1 for i in sources]


def test_sample():
    assert solution(3, [[1, 2], [2, 3]], [2, 3], 1) == [1, 2]
    assert solution(5, [[1, 2], [1, 4], [2, 4], [2, 5], [4, 5]], [1, 3, 5], 5) == [
        2,
        -1,
        0,
    ]
