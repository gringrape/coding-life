def has_duplicate_letters_set(string):
    distinct_letters = set()

    for l in string:
        if l in distinct_letters:
            return True
        distinct_letters.add(l)

    return False


def has_duplicate_letters_set_compare_length(string):
    distinct_letters = set(string)
    return len(string) > len(distinct_letters)


def has_duplicate_letters_brute_force(string):
    for i in range(len(string)):
        for j in range(i + 1, len(string)):
            if string[i] == string[j]:
                return True
    return False


def has_duplicate_letters_brute_force_any(string):
    return any(
        string[i] == string[j]
        for i in range(len(string))
        for j in range(i + 1, len(string))
    )


def has_duplicate_letters_sorting(string):
    string_in_lexicographic_order = sorted(string)

    return any(
        string_in_lexicographic_order[i] == string_in_lexicographic_order[i + 1]
        for i in range(len(string) - 1)
    )


def test_has_duplicate_letters():
    for has_duplicate_letters in (
        has_duplicate_letters_set,
        has_duplicate_letters_set_compare_length,
        has_duplicate_letters_brute_force,
        has_duplicate_letters_brute_force_any,
        has_duplicate_letters_sorting,
    ):
        assert has_duplicate_letters("aa") == True
        assert has_duplicate_letters("ab") == False
        assert has_duplicate_letters("abccc") == True
        assert has_duplicate_letters("abcdefga") == True
