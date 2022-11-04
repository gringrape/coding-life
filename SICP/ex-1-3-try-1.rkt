#lang sicp

(define (square x) (* x x))

(max 1 3 2) ; 3

(define (second-max a b c)
  (cond ((= a (max a b c)) (max b c))
        ((= b (max a b c)) (max a c))
        ((= c (max a b c)) (max a b))))

(second-max 1 3 2) ; 2

(define (sum-squares-larger-two a b c)
  (+ (square (max a b c))
     (square (second-max a b c))))

(sum-squares-larger-two 1 3 2) ; 13
(sum-squares-larger-two 5 8 10) ; 164

#|
  첫번째 풀이 오답
  (define (square x) x * x) => 표기법이 틀렸다.

  배운 것
  1. define 문법
|#
