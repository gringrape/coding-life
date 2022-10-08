def valid_path_stack(n, edges, source, destination):
    if source == destination:
        return True

    neighbors = {}

    for i, v in edges:
        if i not in neighbors:
            neighbors[i] = set()
        if v not in neighbors:
            neighbors[v] = set()
        neighbors[i].add(v)
        neighbors[v].add(i)

    visited = {}
    for node in neighbors:
        visited[node] = False

    stack = [source]
    while stack:
        node = stack.pop()

        if visited[node]:
            continue

        if node == destination:
            return True

        visited[node] = True
        for n in neighbors[node]:
            stack.append(n)

    return False


def valid_path_recursion(n, edges, source, destination):
    if source == destination:
        return True

    neighbors = {}

    for i, v in edges:
        if i not in neighbors:
            neighbors[i] = set()
        if v not in neighbors:
            neighbors[v] = set()
        neighbors[i].add(v)
        neighbors[v].add(i)

    visited = {}
    for node in neighbors:
        visited[node] = False

    def check_connected(start, end):
        if start == end:
            return True

        if visited[start]:
            return False

        visited[start] = True

        return any(check_connected(start=n, end=end) for n in neighbors[start])

    return check_connected(source, destination)


class Graph:
    nodes: dict

    def __init__(self):
        self.nodes = {}

    def get(self, value):
        if value in self.nodes:
            return self.nodes[value]

        newNode = Node(value)

        self.nodes[value] = newNode

        return newNode


class Node:
    value: int
    neighbors: set
    visited: bool

    def __init__(self, value):
        self.value = value
        self.neighbors = set()
        self.visited = False

    def addNeighbor(self, node):
        self.neighbors.add(node)

    def visit(self):
        self.visited = True


def valid_path_neighbor_list(n, edges, source, destination):
    if source == destination:
        return True

    graph = Graph()

    for i, v in edges:
        first = graph.get(i)
        second = graph.get(v)
        first.addNeighbor(second)
        second.addNeighbor(first)

    def check_connected_to_destination(start):
        if start.value == destination:
            return True

        if start.visited:
            return False

        start.visit()

        return any(check_connected_to_destination(n) for n in start.neighbors)

    startNode = graph.get(source)
    return check_connected_to_destination(startNode)


def valid_path_bfs(n, edges, source, destination):
    if source == destination:
        return True

    neighbors = {}

    for i, v in edges:
        if i not in neighbors:
            neighbors[i] = set()
        if v not in neighbors:
            neighbors[v] = set()
        neighbors[i].add(v)
        neighbors[v].add(i)

    visited = {}
    for node in neighbors:
        visited[node] = False

    queue = [source]
    while queue:
        node = queue.pop()
        visited[node] = True

        if node == destination:
            return True
        for n in neighbors[node]:
            if not visited[n]:
                queue.insert(0, n)

    return False


solutions = [
    valid_path_stack,
    valid_path_recursion,
    valid_path_neighbor_list,
    valid_path_bfs,
]


def test_validPath():
    for validPath in solutions:
        assert validPath(n=1, edges=[], source=0, destination=0) == True

        assert validPath(n=2, edges=[[0, 1]], source=0, destination=1) == True

        assert (
            validPath(
                n=3,
                edges=[
                    [2, 3],
                    [1, 2],
                ],
                source=1,
                destination=3,
            )
            == True
        )
