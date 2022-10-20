# 완전 탐색
# - 모든 경우를 조사한다.
# - 재귀적 방법을 사용한다.


def count_maximum_dungeons(k, dungeons):
    next_dungeons = [[require, cost] for require, cost in dungeons if k >= require]

    if k < 0 or len(next_dungeons) == 0:
        return 0

    return 1 + max(
        count_maximum_dungeons(
            k - cost, next_dungeons[0:index] + next_dungeons[index + 1 :]
        )
        for index, (require, cost) in enumerate(next_dungeons)
    )


def test_solution():
    assert count_maximum_dungeons(80, [[80, 20], [50, 40], [30, 10]]) == 3
    assert count_maximum_dungeons(80, [[90, 20]]) == 0
