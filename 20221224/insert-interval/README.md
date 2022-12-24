# Insert Interval
https://leetcode.com/problems/insert-interval/

## 풀이 계획
- 인터벌(intervals)들 중에서 새로운 인터벌과 겹치는 것들과 그렇지 않은 것들을 구분한다.
- 겹치는 인터벌들의 경우 하나로 병합한다. 
- 병합된 인터벌과 겹치지 않은 인터벌을 하나로 합쳐서 내놓는다.

## 회고
두개의 인터벌이 겹치는 지 확인하는 프로시저에서 오류가 있었다.

다음과 같은 케이스는 검증했으나,
```python
[1, 3], [2, 5]
```

다음은 검증하지 못했다.
```python
[1, 8], [2, 5]
```

안되는 케이스를 이해하자 구현을 수정하는 것은 쉬운 일이었다. 

```python
def isOverlapped(interval1, interval2):
    start1, end1 = interval1
    start2, end2 = interval2
    return max(start1, start2) <= min(end1, end2)
```
프로시저를 작게 나누고자 한다면, 별도의 테스트를 구성하고 
여러가지 케이스를 생각하는 작업이 꼭 필요하다. 
