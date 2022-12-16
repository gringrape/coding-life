# Top K Frequent Elements
- 주어진 것: 숫자들 `nums`, 자연수 `k`
- 구하는 것: 숫자들에서 가장 빈번한 숫자 `k`개
- 전략1: 등장 횟수를 센다 -> 정렬한다 -> 상위 k개를 반환한다. 

## 전략1의 수행
- python을 활용함.
- python의 `Counter`을 통해 해결. 

다음과 같은 방법을 지원한다. 
```python
Counter(nums).most_common(k)
```
- most_common의 구현을 살펴보면 heapq를 활용하는 것을 알수 있다.
- count를 우선순위로 하는 우선순위큐를 활용하고, 이에 대한 구현으로 heap을 사용한다. 
- 시간복잡도 측면에서는 일단 count를 하고, 정렬해서 k개를 반환하는 방식과 다를 것이 없다. 
