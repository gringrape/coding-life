#lang sicp

(define (fast-multiply a b)
  (cond ((= b 0) 0)
        ((even? b) (double (fast-multiply a (halve b))))
        (else (+ a (fast-multiply a (- b 1))))))

(define (double x) (* x 2))
(define (halve x) (/ x 2))

(fast-multiply 4 198) ; 792
(fast-multiply 7782 6668) ; 51890376

