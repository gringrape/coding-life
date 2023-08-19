#lang sicp

(#%require "accumulate.rkt")

; 예시
; a2 x^2 + a1 x + a0 =>
; 0 -> 0 x + a2 -> a2 x + a1 -> a2 x^2 + a1 x + a0

(#%require rackunit)

(define (honer-eval x coefficients)
  (accumulate (lambda (b a) (+ (* a x) b))
              0
              coefficients))

(check-equal? (honer-eval 2 (list 1 3 1)) (+ 1 6 4))

; accumulate
(check-equal? (accumulate + 0 (list 1 2 3)) 6)
