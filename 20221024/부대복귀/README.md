# 부대복귀

https://school.programmers.co.kr/learn/challenges?page=1&statuses=unsolved&levels=2

## 풀이 구상
- 목적지로 부터 모든 장소의 최단거리를 구한다.
- BFS를 염두해두고 풀이 구상. 

## 체크할 것
```python
def solution(n, roads, sources, destination):
    neighbors = {i: [] for i in range(1, n + 1)}

    for start, end in roads:
        neighbors[start].append(end)
        neighbors[end].append(start)

    distances = {}
    visited = set()

    queue = [(destination, 0)]
    visited.add(destination)
    while queue:
        node, distance = queue.pop(0)
        distances[node] = distance 
        # 여기가 아니라,
        for neighbor in neighbors[node]:
            if neighbor not in visited:
                queue.append((neighbor, distance + 1))
                visited.add(neighbor) # 여기에서 방문 체크를 해주어야 함.

    return [distances[i] if i in distances else -1 for i in sources]


```
