def zip_string(string):
    pairs = []

    count = 0
    for i in range(len(string)):
        if i < len(string) - 1 and string[i] == string[i + 1]:
            count += 1
            continue

        pairs.append((string[i], count + 1))
        count = 0

    zipped = "".join((letter + str(count) for letter, count in pairs))

    return zipped if len(zipped) < len(string) else string


def test_zip_string():
    assert zip_string("aabcccaaa") == "a2b1c3a3"
    assert zip_string("abc") == "abc"
