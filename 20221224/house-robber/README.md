# House Robber
## 문제 링크
https://leetcode.com/problems/house-robber/

## 문제 분석

### 구하는 것
훔칠 수 있는 최대 금액

### 조건
- `경보`를 울리지 말아야 한다.
- 인접한 두집에서 모두 훔친다면 `경보`가 울리게 된다. 

### 풀이 계획
- 첫번째 집에서 물건을 훔쳤을 경우와 훔치지 않았을 경우로 나눈다. 
- 두 경우에서 최대 금액을 구하고, 둘 중에서 더 큰 값을 취한다. 
- 집이 한 곳이 남았거나, 남지 않았을 경우의 경계 조건을 구한다. 

### 풀이
- memoization 기법을 이용해서 중복되는 계산 제거. 
  -> 수행시간 초과가 발생함.
- bottom up 방식을 사용하자. 
- bottom up 방식을 사용하니 시간초과가 해결되었다. 

## 풀이 회고
처음에는 풀이 계획 그대로에 재귀를 이용해서 풀이했다. 

```python
def rob(houses):
  if not houses:
    return 0

  steal = houses[0]
  
  return max(
    steal + rob(houses[:2]),
    rob(houses[:1])
  )
```

풀이 코드의 가독성이 좋고 명쾌하지만, 효율성 조건에 실패했다.
이 함수는 재귀 process를 생성하고 반복적으로 같은 계산을 수행하기 때문에 개선이 필요하다.
그래서, memoization을 활용했다. 

```python
def rob(houses, index=0, memo=None):
    if not memo:
        memo = dict()

    if index >= len(houses):
        return 0

    if index not in memo:
        memo[index] = max(
            houses[index] + rob_memo(houses, index + 2, memo),
            rob_memo(houses, index + 1, memo)
        )

    return memo[index]
```

memoization을 사용해도 시간 개선이 되지 않았다.
bottom up 방식(꼬리재귀)을 이용해서 개선해주었다.

```python
def rob_bottom_up(houses):
    def rob_iterate(currentHouseIndex, a=0, b=0):
        if currentHouseIndex < 0:
            return a
        return rob_iterate(
          currentHouseIndex = currentHouseIndex - 1, 
          a=max(houses[currentHouseIndex] + b,
          b=a))

    return rob_iterate(len(houses) - 1)

```
