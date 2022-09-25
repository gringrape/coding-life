def check_if_exactly_one_letter_modified(string1, string2):
    if len(string1) != len(string2):
        return False

    modified_count = 0

    other_letters = set(string2)
    for letter in string1:
        if letter not in other_letters:
            modified_count += 1

    return modified_count == 1


def check_if_added_or_deleted(string1, string2):
    if abs(len(string1) - len(string2)) != 1:
        return False

    letters1 = set(string1)
    letters2 = set(string2)

    return letters1.issubset(letters2) or letters2.issubset(letters1)


def check_edit_one_time_or_less(string1, string2):
    return (
        string1 == string2
        or check_if_exactly_one_letter_modified(string1, string2)
        or check_if_added_or_deleted(string1, string2)
    )


def test_check_edit_one_time_or_less_equal():
    assert check_edit_one_time_or_less("abc", "abc") == True


def test_check_edit_one_time_or_less_modify():
    assert check_edit_one_time_or_less("abcde", "abcdf") == True
    assert check_edit_one_time_or_less("abcdefg", "abcxefg") == True


def test_check_edit_one_time_or_less_added_or_deleted():
    assert check_edit_one_time_or_less("abcd", "abcdf") == True
    assert check_edit_one_time_or_less("xyzc", "abcdf") == False
