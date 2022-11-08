#lang sicp

(define (a-plus-abs-b a b)
  ((if (> b 0) + -) a b))

(a-plus-abs-b 3 5) ; 8
(a-plus-abs-b 3 -5) ; 8

#|
  배운 것

  우리가 모델링한 evaluation은,
  operator가 compound expression인 combination도 허용한다.

  ((if (> b 0) + -) a b)
|#
