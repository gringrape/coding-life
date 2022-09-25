def url(string):
    return "".join(x if x != " " else "%20" for x in string)


def url_for(string):
    result = ""
    for letter in string:
        if letter == " ":
            result += "%20"
            continue
        result += letter
    return result


solutions = (url, url_for)


def test_url():
    for url in solutions:
        assert url("Mr John Smith") == "Mr%20John%20Smith"
