#lang sicp

; 최대공약수를 구하는 Procedure는 다음과 같다 .
;
; (define (gcd a b)
;   (if (= b 0)
;       a
;       (gcd b (remainder a b))))
;
; 구하는 것은 (gcd 206 40)을 normal-order로 해석할때,
; remainder 연산자를 몇회 실행하게되는가이다.
;
; 총 몇 단계의 연산을 하게 되는지 부터 계산해보자.
; gcd(206, 40)
; = gcd(40, 6)
; = gcd(6, 4)
; = gcd(4, 2)
; = gcd(2, 0) => 종료
; 다섯단계를 거치면 종료된다.
;
; normal-order 이므로, 모두 전개되기 전까지는 인자를 평가하지 않는다.
; 이 때, b 가 n 번째 단계에서 포함하는 remainder 연산의 수를 f(n) 이라고 하자.
; 그러면 a 가 n 번째 단계에서 포함하는 remainder 연산의 수는 f(n - 1)이 된다.
;
; 또, f(n + 1) = f(n) + f(n - 1) + 1 이라는 관계식이 성립하게 된다.
; 이 식을 변형하면, f(n + 1) + 1 = f(n) + 1 + f(n - 1) + 1 이 되고,
; f(n) + 1 => fib(n) 으로 치환 하면,
; fib(n + 1) = fib(n) + fib(n - 1) 이 되어, 피보나치 수열이 된다.
;
; 총 다섯 단계를 거치면서 b는 5회, a는 마지막 1회 평가된다.
; 따라서, 총 호출 횟수는 f(1) + ... + f(5) + f(4) 가 된다.
;
; 일반식으로 표현하면, n 단계를 거칠때 b는 n 회, a는 1회 평가된다.
; 따라서, 총 remainder 호출수는
; sum(f(k) for k from 1 to n) + f(n - 1)
; = sum(fib(k) - 1 for k 1 to n) + f(n - 1)
; = sum(fib(k) for k from 1 to n) - n + fib(n - 1) - 1
;
; f(0) = 0, f(1) = 0 이므로,
; fib(0) = 1, fib(1) = 1 이다.
; 따라서, 다섯 단계에서 총 remainder 호출 수는,
; = (1 + 2 + 3 + 5 + 8) - 5 + 5 - 1
; = 19 - 1 = 18
