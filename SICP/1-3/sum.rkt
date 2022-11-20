#lang sicp

; Implementation of generalized sum

(define (sum term a next b)
  (if (> a b)
      0
      (+ (term a) (sum term (next a) next b))))

"Sum of integers(1 ~ 10): "
(define (sum-integers a b)
  (sum identity a inc b))

(sum-integers 1 10) ; 55

"Sum of cubes(1 ~ 4)"
(define (sum-cubes a b)
  (sum cube a inc b))

(define (cube x) (* x x x))

(sum-cubes 1 4) ; 100

"Approximation of Pi"
(define (pi-sum a b)
  (sum pi-term a pi-next b))

(define (pi-term a) (/ 1.0 (* a (+ a 2))))

(define (pi-next a) (+ a 4))

(pi-sum 1 10000) ; 0.39...
