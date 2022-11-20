#lang sicp

(define (integral-cube a b)
  (integral cube a b))

(define (integral f a b)
  (approximate-integral f a b 0.000001)) ; dx 조절 가능

(define (approximate-integral f a b dx)
  (define (next x) (+ x dx))
  (* (sum f (+ a (/ dx 2)) next b)
     dx))

(define (sum term a next b)
  (if (> a b)
      0
      (+ (term a) (sum term (next a) next b))))

(define (cube x) (* x x x))

(integral-cube 0 1) ; 1/4
(integral-cube 1 2) ; 3.75
