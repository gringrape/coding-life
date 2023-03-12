from collections import defaultdict


def initialize_orders(numberOfNodes, edges):
    orders = [0] * numberOfNodes

    for skill, requisite_skill in edges:
        orders[skill] += 1

    return orders


def test_initialize_orders():
    assert initialize_orders(
        numberOfNodes=3,
        edges=[[1, 0], [2, 0]]
    ) == [0, 1, 1]


def initialize_graph(edges):
    graph = defaultdict(lambda: list())

    for first, second in edges:
        graph[second].append(first)

    return graph


def test_initialize_graph():
    assert initialize_graph(
        edges=[[1, 0], [2, 0]]
    ) == {
        0: [1, 2],
    }

    assert initialize_graph(
        edges=[[1, 0], [2, 0], [2, 1]]
    ) == {
        0: [1, 2],
        1: [2]
    }


def find_order(numCourses, prerequisites):
    orders = initialize_orders(
        numberOfNodes=numCourses,
        edges=prerequisites
    )

    graph = initialize_graph(edges=prerequisites)

    queue = [i for i in range(numCourses) if orders[i] == 0]

    result = []
    while queue:
        result = [*result, *queue]

        neigbors = []
        for node in queue:
            neigbors.extend(graph[node])

        queue.clear()

        for node in neigbors:
            orders[node] -= 1
            if orders[node] == 0:
                queue.append(node)

    return result if len(result) == numCourses else []


def test_find_order():
    assert find_order(
        numCourses=4,
        prerequisites=[[1, 0], [2, 0], [3, 1], [3, 2]]
    ) == [0, 1, 2, 3]
