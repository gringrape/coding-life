def get_row_top_down(index):
    if index == 0:
        return [1]

    last_row = get_row_top_down(index - 1)
    return [
        last_row[0],
        *(last_row[i] + last_row[i + 1] for i in range(len(last_row) - 1)),
        last_row[-1],
    ]


def get_row_bottom_up(index):
    row = [1]

    for _ in range(index):
        row = [row[0], *(row[i] + row[i + 1] for i in range(len(row) - 1)), row[-1]]

    return row


solutions = [get_row_top_down]


def test_get_row():
    for get_row in solutions:
        assert get_row(index=0) == [1]
        assert get_row(index=1) == [1, 1]
        assert get_row(index=2) == [1, 2, 1]
        assert get_row(index=3) == [1, 3, 3, 1]
