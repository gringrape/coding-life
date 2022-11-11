#lang sicp

(define (multiply a b)
  (multiply-iterative 0 a b))

(define (multiply-iterative s a b)
  (cond ((= b 0) s)
        ((even? b) (multiply-iterative s (double a) (halve b)))
        (else (multiply-iterative (+ s a) a (- b 1)))))

(define (double x) (* x 2))
(define (halve x) (/ x 2))

(multiply 4 198) ; 792
(multiply 7782 6668) ; 51890376
