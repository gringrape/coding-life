class Survey:
    def __init__(self):
        self.indicators = [
            {"key": "RT", "R": 0, "T": 0},
            {"key": "CF", "C": 0, "F": 0},
            {"key": "JM", "J": 0, "M": 0},
            {"key": "AN", "A": 0, "N": 0},
        ]

    def record(self, question, choice):
        typeA, typeB = question
        if choice < 4:
            self.plus(typeA, 4 - choice)
        if choice > 4:
            self.plus(typeB, choice - 4)

    def plus(self, type, score):
        indicator = next(
            indicator for indicator in self.indicators if type in indicator["key"]
        )
        indicator[type] += score

    def result(self):
        return "".join(self.reduce(indicator) for indicator in self.indicators)

    def reduce(self, indicator):
        indicator_without_key = sorted(
            [item for item in indicator.items() if item[0] != "key"], key=lambda x: x[0]
        )
        return next(
            key
            for key, value in sorted(
                indicator_without_key, reverse=True, key=lambda x: x[1]
            )
        )


def solution(questions, choices):
    survey = Survey()
    for i in range(len(questions)):
        survey.record(questions[i], choices[i])
    return survey.result()


def test_sample():
    assert solution(["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5]) == "TCMA"
    assert solution(["TR", "RT", "TR"], [7, 1, 3]) == "RCJA"
