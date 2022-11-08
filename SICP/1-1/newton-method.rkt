#lang sicp

(define (square-root x)
  (square-root-iter 1.0 x))

(define (square-root-iter guess x)
  (if (good-enough guess x)
      guess
      (square-root-iter (improve guess x) x)))

(define (good-enough guess x)
  (< (abs (- (square guess) x)) 0.001))

(define (improve guess x)
  (average guess (/ x guess)))

(define (square x) (* x x))

(define (average x y) (/ (+ x y) 2))

(square-root 4) ; 2
(square-root 2) ; 1.414...
