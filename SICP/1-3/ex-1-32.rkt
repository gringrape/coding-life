#lang sicp

(define (accumulate combiner null-value term a next b)
  (if (> a b)
      null-value
      (combiner (term a) (accumulate combiner
                                     null-value
                                     term
                                     (next a)
                                     next
                                     b))))

(define (sum a b)
  (accumulate + 0 identity a inc b))

(sum 1 5) ; 15
(sum 9 19) ; 154

(define (product a b)
  (accumulate * 1 identity a inc b))

(product 1 5) ; 120
(product 4 7) ; 840
