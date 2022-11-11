#lang sicp

(define (power b n)
  (cond ((= n 0) 1)
        ((even? n) (square (power b (/ n 2))))
        (else (* b (power b (- n 1))))))

(define (square x) (* x x))

(power 2 5) ; 32
(power 3 4) ; 81
(power 3 5) ; 243
