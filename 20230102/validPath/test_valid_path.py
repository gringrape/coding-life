# 풀이 계획
# - datastructure interface 정의 -> union, isConnected
# - 구현
#   - quick union 방식 => 겁나 느림.
#   - quick union with path compression 방식

class DisjointSet:
    def __init__(self, n):
        self.ids = [i for i in range(n)]

    def union(self, start, end):
        # 원하는것. 양쪽 컴포넌트의 값을 모두 바꾸어준다.
        # - start, end 중 값을 통일할 하나를 고른다 -> start
        # - 전체 ids 를 탐색하면서 end 로 되어 있는 것들을 모두 start 로 바꾼다.
        united_id = self.ids[start]
        removing_id = self.ids[end]
        self.ids = [
            united_id if id == removing_id else id
            for id in self.ids
        ]

    def is_connected(self, one, another):
        return self.ids[one] == self.ids[another]


def valid_path(n, edges, source, destination):
    disjointSet = DisjointSet(n)

    for start, end in edges:
        disjointSet.union(start, end)

    return disjointSet.is_connected(source, destination)


def test_sample():
    assert valid_path(
        n=3, edges=[[0, 1], [1, 2], [2, 0]], source=0, destination=2
    ) == True
