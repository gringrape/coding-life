class SpiralMatrix:
    EMPTY = -1

    def __init__(self, size):
        self.size = size
        self.matrix = [[self.EMPTY] * size for row in range(size)]
        self.x = 0
        self.y = 0
        self.direction = [1, 0]

    def is_out_of_bound(self, x, y):
        size = self.size
        return x < 0 or x >= size or y < 0 or y >= size

    def is_already_filled(self, x, y):
        return self.matrix[y][x] != self.EMPTY

    def is_blocked(self):
        dx, dy = self.direction

        x = self.x + dx
        y = self.y + dy

        return self.is_out_of_bound(x, y) or self.is_already_filled(x, y)

    def turn(self):
        dx, dy = self.direction
        self.direction = [-dy, dx]

    def go(self):
        if self.is_blocked():
            self.turn()

        dx, dy = self.direction
        self.x += dx
        self.y += dy

    def generate(self):
        for i in range(self.size ** 2):
            self.matrix[self.y][self.x] = i
            self.go()

        return self.matrix


def test_generate_matrix_size_2():
    matrix = SpiralMatrix(size=2)
    assert matrix.generate() == [[0, 1], [3, 2]]


def test_generate_matrix_size_3():
    matrix = SpiralMatrix(size=3)
    assert matrix.generate() == [[0, 1, 2], [7, 8, 3], [6, 5, 4]]


def test_generate_matrix_size_3():
    matrix = SpiralMatrix(size=4)
    assert matrix.generate() == [
        [0, 1, 2, 3],
        [11, 12, 13, 4],
        [10, 15, 14, 5],
        [9, 8, 7, 6],
    ]


def test_go():
    matrix = SpiralMatrix(size=2)

    matrix.go()
    assert matrix.x == 1
    assert matrix.y == 0

    matrix.go()
    assert matrix.x == 1
    assert matrix.y == 1


def test_turn():
    matrix = SpiralMatrix(size=2)

    assert matrix.direction == [1, 0]

    matrix.turn()

    assert matrix.direction == [0, 1]

    matrix.turn()

    assert matrix.direction == [-1, 0]

    matrix.turn()

    assert matrix.direction == [0, -1]

    matrix.turn()

    assert matrix.direction == [1, 0]
