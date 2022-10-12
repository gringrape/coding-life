def pascal_triangle_top_down(number_of_rows):
    if number_of_rows == 1:
        return [[1]]

    triangle = pascal_triangle_top_down(number_of_rows - 1)

    *_, last_row = triangle

    new_row = [
        last_row[0],
        *(last_row[i] + last_row[i + 1] for i in range(len(last_row) - 1)),
        last_row[-1],
    ]

    return [*triangle, new_row]


def pascal_triangle_bottom_up(number_of_rows):
    if number_of_rows == 1:
        return [[1]]

    triangle = [[1], [1, 1]]

    for _ in range(number_of_rows - 2):
        *_, last_row = triangle

        new_row = [
            last_row[0],
            *(last_row[i] + last_row[i + 1] for i in range(len(last_row) - 1)),
            last_row[-1],
        ]

        triangle.append(new_row)

    return triangle


solutions = [pascal_triangle_top_down, pascal_triangle_bottom_up]


def test_pascal_triangle():
    for pascal_triangle in solutions:
        assert pascal_triangle(1) == [[1]]
        assert pascal_triangle(2) == [[1], [1, 1]]
        assert pascal_triangle(3) == [[1], [1, 1], [1, 2, 1]]
        assert pascal_triangle(5) == [
            [1],
            [1, 1],
            [1, 2, 1],
            [1, 3, 3, 1],
            [1, 4, 6, 4, 1],
        ]
