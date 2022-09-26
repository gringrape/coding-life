def rotate(array):
    N = len(array)

    for i in range(0, round((N + 1) / 2)):
        for j in range(i, N - i - 1):
            temp = array[i][j]
            array[i][j] = array[N - j - 1][i]
            array[N - j - 1][i] = array[N - i - 1][N - j - 1]
            array[N - i - 1][N - j - 1] = array[j][N - i - 1]
            array[j][N - i - 1] = temp

    return array


def test_ratate():
    assert rotate([[1, 2, 3], [4, 5, 6], [7, 8, 9]]) == [
        [7, 4, 1],
        [8, 5, 2],
        [9, 6, 3],
    ]

    assert rotate([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16],]) == [
        [13, 9, 5, 1],
        [14, 10, 6, 2],
        [15, 11, 7, 3],
        [16, 12, 8, 4],
    ]
