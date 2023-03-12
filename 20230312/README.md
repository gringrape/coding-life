# LeetCode 문제 풀이

## 1. Corporate Flight Bookings
### 구하는 것 
answer, answer[i] is the total number of seats reserved for flight i.

### 주어진 것 
bookings
```
bookings[i] = [firsti, lasti, seatsi]
```

### 누적합 풀이 예시
[1, 2, 10],
[2, 3, 20],
[2, 5, 25]

[10, 45, -10, -20, 0, -25]

=> [10, 55, 45, 25, 25]

### 풀이 해설
`Bookings` 배열을 누적합 알고리즘을 이용해서 
동일한 정보를 나타내는 `sparse array`로 나타낼 수 있다. 
`sparse array` 끼리의 연산을 통해서 문제의 해답을 구할 수 있다. 

## 2. Course Schedule II

## 구하는 것
모든 강좌를 수강하기 위해 필요한 강좌 순서

## 주어진 것
- 전체 강좌의 개수 
- 선수 강좌(prerequisites)배열

## 풀이
### 위상정렬 활용
그래프를 구하고 위상차이를 이용해서 정렬하는 방법을 나타냄. 
노드의 위상과 노드간의 연결(간선)을 기록하고, 
위상이 낮은 것 부터 순회하며 답을 구하는 방법. 

## 위상정렬의 활용
dependency graph 를 그릴때 사용될 수 있다. 
