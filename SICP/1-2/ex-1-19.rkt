#lang sicp

(define (fibonacci n)
  (fibonacci-iterative 1 0 0 1 n))

(define (fibonacci-iterative a b p q count)
  (cond ((= count 0) b)
        ((even? count) (fibonacci-iterative a
                                            b
                                            (+ (square p) (square q))
                                            (+ (square q) (* 2 p q))
                                            (/ count 2)))
        (else (fibonacci-iterative (+ (* b q) (* a q) (* a p))
                                   (+ (* b p) (* a q))
                                   p
                                   q
                                   (- count 1)))))

(define (square x) (* x x))

(fibonacci 10) ; 55
(fibonacci 12) ; 144
