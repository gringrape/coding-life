#lang sicp

"10" 10 ;10

"(+ 5 3 4)" (+ 5 3 4) ;12

"(- 9 1)" (- 9 1) ;8

"(/ 6 2)" (/ 6 2) ;3

"(+ (* 2 4) (* 4 6))" (+ (* 2 4) (* 4 6)) ;32

"(define a 3)" (define a 3)

"(define b (+ a 1))" (define b (+ a 1))

"(+ a b (* a b))" (+ a b (* a b))
#|
  a = 3
  b = a + 1 = 4
  (+ a b (* a b))
  = (+ 3 4 12)
  = 19
|#

(= a b) ; testing a equals b
(= 3 3) ; #t, true

(if (> b a)
    b
    a) ;b, 4

(if (and (> b a) (< b (* a b)))
    b
    a) ;b, 4

(cond ((= a 4) 6)
      ((= b 4) (+ 6 7 a))
      (else 25)) ;16

(+ 2 (if (> b a) b a)) ;6

(* (cond ((> a b) a)
         ((< a b) b)
         (else -1)
         ) (+ a 1)) ;16

#|
  배운 것

  1. single-line comment => ;
  2. multi-line comment => #||#
  3. testing => (= 3 3)
    - https://www.cs.cmu.edu/Groups/AI/html/r4rs/r4rs_6.html
  4; cond
  5. Scheme formatting => 어디서 줄바꿈하는 것이 좋은지
|#

