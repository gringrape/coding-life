#lang sicp

; Simpson's Rule을 이용하여 적분값 계산하기

(define (approximate-integral f a b n)
  (define h (/ (- b a) n))

  (define (term-simpson a)
    (+ (f a) (* 4 (f (+ a h))) (f (+ a (* 2 h)))))

  (define (next-simpson a) (+ a (* 2 h)))

  (/ (* h (sum term-simpson a next-simpson b)) 3))

(define (sum term a next b)
  (if (>= a b)
      0
      (+ (term a) (sum term (next a) next b))))

(define (cube x) (* x x x))

(approximate-integral cube 0 1.0 100)
(approximate-integral cube 0 1.0 1000)
