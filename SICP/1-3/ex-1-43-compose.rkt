#lang sicp

; repeated
(define (repeated f n)
  (if (> n 1)
      (compose f (repeated f (dec n)))
      f))

(define (square x) (* x x))

; compose
(define (compose f g)
  (lambda (x) (f (g x))))

((repeated square 2) 5) ; 625
