#lang sicp

; 매우 큰 수에서는 값을 표현하는 유효숫자의 크기가 너무 커질 수 있다.
;

(define (square-root x)
  (square-root-iter 1.0 x))

(define (good-enough-improved? guess x)
  (< (abs (- (improve guess x) guess)) (* guess 0.0001)))

(define (square-root-iter guess x)
  (if (good-enough-improved? guess x)
      guess
      (square-root-iter (improve guess x) x)))

(define (good-enough? guess x)
  (< (abs (- (square guess) x)) 0.0001))

(define (improve guess x)
  (average guess (/ x guess)))

(define (square x) (* x x))

(define (average x y) (/ (+ x y) 2))

(square-root 4) ; 2
(square-root 2) ; 1.414...

; 답이 나오지 않는 경우
; 1. 매우 작은 수의 경우, 설정해놓은 한계치(0.0001)가 너무 커서 정확한 답이 나오지 않는다.
(square-root 0.00000001)

; 2. 매우 큰 수의 경우 유효숫자의 한계가 있기 때문에, 너무 작은 수는 표현되지 못한다.
(square-root 10000000000000) ; 10 ** 13, 이 경우에는 무한루프에 빠진다.

; 개선해보자
; 1. 등호로 비교해서 machine이 한계까지 비교할 수 있다.
; (define (good-enough-improved? guess x)
;   (= (improve guess x) guess))
; 2. 구하는 숫자와 비례해서 범위를 정한다. -> 큰 수와 작은 수 모두에 대응할 수 있다.
; (define (good-enough-improved? guess x)
;   (< (abs (- (improve guess x) guess)) (* guess 0.0001)))


