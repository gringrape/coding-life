def solution(k, m, score):
    def maxScoreSum(scores):
        if len(scores) < m:
            return 0
        maxScore = m * scores[m - 1]
        return maxScore + maxScoreSum(scores[m:])

    return maxScoreSum(sorted(score, reverse=True))


def solution_2(k, m, score):
    scoresBiggerFirst = sorted(score, reverse=True)

    sum = 0
    index = m - 1
    while index < len(score):
        sum += scoresBiggerFirst[index] * m
        index += m

    return sum


solutions = [solution, solution_2, solution]


def test_solution():
    for solution in solutions:
        assert solution(k=3, m=4, score=[1, 2, 3, 1, 2, 3, 1]) == 8
        assert solution(k=4, m=3, score=[
                        4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2, 3]) == 33
