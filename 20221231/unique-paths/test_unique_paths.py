def uniquePaths_simple_recursion(m, n):
    def countPaths(r, c):
        if r == m - 1 and c == n - 1:
            return 1

        if r < 0 or r >= m or c < 0 or c >= n:
            return 0

        return countPaths(r + 1, c) + countPaths(r, c + 1)

    return countPaths(0, 0)


def uniquePaths_memoization(m, n):
    counts = dict()

    def countPaths(r, c):
        if r == m - 1 and c == n - 1:
            return 1

        if r < 0 or r >= m or c < 0 or c >= n:
            return 0

        position = f'{r}-{c}'
        if position not in counts:
            counts[f'{r}-{c}'] = countPaths(r + 1, c) + countPaths(r, c + 1)

        return counts[position]

    return countPaths(0, 0)


solutions = [
    uniquePaths_simple_recursion,
    uniquePaths_memoization,
]


def test_unique_paths():
    for uniquePaths in solutions:
        assert uniquePaths(m=3, n=7) == 28
        assert uniquePaths(m=3, n=2) == 3
