def is_subsequence(s, t):
    if len(s) == 0:
        return True

    index = t.find(s[0])

    if index < 0:
        return False

    return is_subsequence(s[1:], t[index + 1 :])


def test_is_subsequence():
    assert is_subsequence("a", "ahbgdc") == True
    assert is_subsequence("x", "ahbgdc") == False
    assert is_subsequence("ax", "ahbgdc") == False
    assert is_subsequence("abc", "ahbgdc") == True
    assert is_subsequence("adc", "ahbgdc") == True
    assert is_subsequence("acb", "ahbgdc") == False
