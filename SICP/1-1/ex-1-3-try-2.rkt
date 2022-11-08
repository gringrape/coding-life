#lang sicp

(define (sumOfLargestTwoSquared x y z)
  (cond ((and (> (+ x y) (+ y z)) (> (+ x y) (+ x z))) (squareSum x y))
        ((and (> (+ y z) (+ x z)) (> (+ y z) (+ x y))) (squareSum y z))
        ((and (> (+ z x) (+ x y)) (> (+ z x) (+ y z))) (squareSum z x))
        ))

(define (squareSum x y)
  (+ (* x x) (* y y)))

(sumOfLargestTwoSquared 1 3 2) ; 13
(sumOfLargestTwoSquared 5 8 10) ; 164

#|
  이름 다듬기

  sum-squares-larger-two => sumOfLargestTwoSquared
   => squared를 뒤에 붙인 것에 주목하자

  배운 것
  - 이름 짓기 - 분사 형태를 잘 활용하자 (twoSquared)
  - cond 아래에 인자들을 잘 정렬 -> 복붙이 편하도록 마지막 괄호는 한줄 더 띄우자.
        ((and (> (+ y z) (+ x z)) (> (+ y z) (+ x y))) (squareSum y z))
        ((and (> (+ z x) (+ x y)) (> (+ z x) (+ y z))) (squareSum z x))
        )) => 이 괄호
|#
