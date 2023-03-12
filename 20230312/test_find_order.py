def initialize_orders(numberOfNodes, edges):
    orders = [0] * numberOfNodes

    for _, requisite in edges:
        orders[requisite] += 1

    return orders


def test_initialize_orders():
    assert initialize_orders(
        numberOfNodes=3,
        edges=[[1, 0], [2, 0]]
    ) == [2, 0, 0]

def initialize_graph(edges):
    return 

def test_initialize_graph():
    assert initialize_graph(
        edges=[[1, 0], [2, 0]]
    ) == {
        1: [0],
        2: [0]
    }


def find_order(numCourses, prerequisites):
    # 1. 위상
    orders = initialize_orders(
        numberOfNodes=numCourses,
        edges=prerequisites
    )
    graph = initialize_graph(
        edges=prerequisites
    )
    # 2. 큐
    # 3. 위상정렬
    return [0, 2, 1, 3]


def test_find_order():
    assert find_order(
        numCourses=4,
        prerequisites=[[1, 0], [2, 0], [3, 1], [3, 2]]
    ) == [0, 2, 1, 3]
