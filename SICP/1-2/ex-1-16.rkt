#lang sicp

; Design a exponentiation procedure that evolves iterative process.

; iterative process는 state를 update하는 procedure를 구현해주어야 함.

(define (power b n)
  (power-iterative 1 b n))

(define (power-iterative a b n)
  (cond ((= n 0) a)
        ((even? n) (power-iterative a (square b) (/ n 2)))
        (else (power-iterative (* a b) b (- n 1)))))

(define (square x) (* x x))

(power 3 5) ; 243


; 배운 것
; - 문자형태보다 구체적인 숫자를 넣은 예시를 통해 문제를 다루면 훨씬 쉬워진다.
