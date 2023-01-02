# 기사단원의 무기
문제: https://school.programmers.co.kr/learn/courses/30/lessons/136798

## 문제 해석
### 구하는 것 
무기를 모두 만들기 위해 필요한 철의 무게

### 주어지는 것
기사단원의수, 공격력 제한 수치, 제한 수치 초과한 기사의 공격력. 
변수명은 각각 number, limit, power

### 조건
- 무기를 만들때 공격력 1당 1kg의 철이 필요하다.
- 기사에게는 기사 번호가 존재한다. 1번 부터 number 까지 부여.

### 예시 풀이
number: 5, limit: 3, power: 2

기사단원: 1, 2, 3, 4, 5
구매 공격력: 1, 2, 2, 3, 2
제한 적용: 1, 2, 2, 3, 2
무게 합산: 10

## 풀이 계획
- 약수 개수로 공격력을 구한다.
- 제한을 적용한다. 
- 합산한다. 

### 약수 개수 구하는 알고리즘 개선
- O(n) -> 약수를 찾기 위해 1 부터 모두 탐색.
- O(n ** 0.5) -> n의 약수 i를 찾으면, n % i 또한 약수가 된다는 것을 이용. 

=> O(logn)으로 개선하기
https://www.geeksforgeeks.org/efficient-program-print-number-factors-n-numbers/
