#lang sicp

(define (smallest-divisor n)
  (find-divisor n 2))

(define (find-divisor n test-divisor)
  (cond ((> (square test-divisor) n) n)
        ((divides? n test-divisor) test-divisor)
        (else (find-divisor n (inc test-divisor)))))

(define (square n)
  (* n n))

(define (divides? a b)
  (= (remainder a b) 0))

(smallest-divisor 1) ; 1
(smallest-divisor 4) ; 2
(smallest-divisor 9) ; 3