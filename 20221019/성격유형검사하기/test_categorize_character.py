class Item:
    def __init__(self, indicators):
        self.indicators = indicators
        self.counts = {indicator: 0 for indicator in self.indicators}

    def result(self):
        return self.indicators[0]


class Character:
    def __init__(self):
        self.items = [
            Item(indicators="RT"),
            Item(indicators="CF"),
            Item(indicators="JM"),
            Item(indicators="AN"),
        ]

    def result(self):
        result = ""
        for item in self.items:
            result += item.result()
        return result


def categorize_character(survey, choices):
    character = Character()
    return character.result()


def test_categorize_character():
    assert categorize_character(survey=[], choices=[]) == "RCJA"
