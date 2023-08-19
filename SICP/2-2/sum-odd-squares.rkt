#lang sicp

(#%require "accumulate.rkt")
(#%require "filter.rkt")
(#%require "enumerate-tree.rkt")

(#%require rackunit)

(define (square number) (* number number))

; Implementation
(define (sum-odd-squares tree)
  (accumulate +
              0
              (map square
                   (filter odd?
                           (enumerate-tree tree)))))

; Test
(check-equal? (sum-odd-squares (list (list 1 3) 5)) 35)
