BLOCKED = 1


def count_unique_path_top_down(grid):
    grid_height = len(grid)
    grid_width = len(grid[0])

    def out_of_bound(r, c):
        return r < 0 or r >= grid_height or c < 0 or c >= grid_width

    def blocked(r, c):
        return grid[r][c] == BLOCKED

    def is_complete(r, c):
        return r == grid_height - 1 and c == grid_width - 1

    memo = [[None] * grid_width for _ in range(grid_height)]

    def count_from(row, column):
        if out_of_bound(row, column) or blocked(row, column):
            return 0

        if is_complete(row, column):
            return 1

        if not memo[row][column]:
            memo[row][column] = count_from(row + 1, column) + count_from(
                row, column + 1
            )

        return memo[row][column]

    return count_from(0, 0)


def count_unique_path_bottom_up(grid):
    grid_height = len(grid)
    grid_width = len(grid[0])

    if grid[0][0] == BLOCKED or grid[grid_height - 1][grid_width - 1] == BLOCKED:
        return 0

    def out_of_bound(r, c):
        return r < 0 or r >= grid_height or c < 0 or c >= grid_width

    def blocked(r, c):
        return grid[r][c] == BLOCKED

    path_counts = [[0] * grid_width for _ in range(grid_height)]
    path_counts[grid_height - 1][grid_width - 1] = 1

    def count(r, c):
        if out_of_bound(r, c) or blocked(r, c):
            return 0

        return path_counts[r][c]

    for row in range(grid_height - 1, -1, -1):
        for column in range(grid_width - 1, -1, -1):
            if row == grid_height - 1 and column == grid_width - 1:
                continue
            path_counts[row][column] = count(row + 1, column) + count(row, column + 1)

    return path_counts[0][0]


solutions = [count_unique_path_top_down, count_unique_path_bottom_up]


def test_unique_path_with_obstacles():
    for count_unique_path in solutions:
        assert (
            count_unique_path(
                grid=[
                    [0],
                ]
            )
            == 1
        )

        assert (
            count_unique_path(
                grid=[
                    [0, 0],
                    [0, 0],
                ]
            )
            == 2
        )

        assert count_unique_path(grid=[[0, 0, 0], [0, 1, 0], [0, 0, 0]]) == 2
