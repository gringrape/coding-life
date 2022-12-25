#lang sicp

; 1. square root procedure

(define (square-root x)
  ((iterative-improvement
    (lambda (guess) (< (abs (- x (square guess))) 0.0001))
    (lambda (guess) (average (/ x guess) guess)))
   1.0))

(define (square x) (* x x))

(define (average a b) (/ (+ a b) 2))

(define (iterative-improvement good-enough? improve-guess)
  (define (iterate guess)
    (if (good-enough? guess)
        guess
        (iterate (improve-guess guess))))
  (lambda (guess) (iterate guess)))

(square-root 16) ; 4

; 2. fixed-point

(define (fixed-point f first-guess)
  ((iterative-improvement
    (lambda (guess) (< (abs (- guess (f guess))) 0.0001))
    (lambda (guess) (f guess)))
   1.0))

(fixed-point cos 1.0) ; 0.7391
