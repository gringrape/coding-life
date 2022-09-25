def is_anagram_sort(string1, string2):
    if len(string1) != len(string2):
        return False

    return sorted(string1) == sorted(string2)


def is_anagram_dict(string1, string2):
    if len(string1) != len(string2):
        return False

    letter_counts = dict()

    # 넣기
    for c in string1:
        if c not in letter_counts:
            letter_counts[c] = 1
            continue
        letter_counts[c] += 1

    # 빼기
    for c in string2:
        if c not in letter_counts or letter_counts[c] <= 0:
            return False

    return True


solutions = (
    is_anagram_sort,
    is_anagram_dict,
)


def test_is_anagram():
    for is_anagram in solutions:
        assert is_anagram("abc", "bac") == True
        assert is_anagram("abcde", "bacdf") == False


def test_is_anagram_different_length():
    for is_anagram in solutions:
        assert is_anagram("abc", "abcd") == False
