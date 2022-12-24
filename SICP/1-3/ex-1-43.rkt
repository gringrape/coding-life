#lang sicp

(define (repeated f n)
  (lambda (x)
    (if (> n 1)
        (f ((repeated f (dec n)) x))
        (f x))))

(define (square x) (* x x))

((repeated square 2) 5) ; 625
