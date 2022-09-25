def is_palindrome_anagram(word):
    counts = {}
    for letter in word:
        if letter == " ":
            continue
        if letter not in counts:
            counts[letter] = 0
        counts[letter] += 1

    count_odd = 0
    for letter, count in counts.items():
        if count % 2 != 0:
            count_odd += 1

    return count_odd <= 1


solutions = (is_palindrome_anagram,)


def test_is_palindrome_anagram_even_length_word():
    assert is_palindrome_anagram("abba") == True
    assert is_palindrome_anagram("aaaabbbb") == True


def test_is_palindrome_anagram_odd_length_word():
    assert is_palindrome_anagram("aba") == True


def test_is_palindrome_anagram_contains_blank():
    assert is_palindrome_anagram("tact coa") == True
