#lang sicp

(#%require rackunit)
(#%require "accumulate.rkt")

; 1. enumerate interval
(define (enumerate-interval a b)
  (if (> a b)
      nil
      (cons a (enumerate-interval (+ 1 a) b))))

(check-equal? (enumerate-interval 1 3) (list 1 2 3))
(check-equal? (enumerate-interval 2 5) (list 2 3 4 5))

; 2. enumerate pairs
(define (unique-pairs n)
  (accumulate append nil
              (map (lambda (i)
                     (map (lambda (j) (list j i)) (enumerate-interval 1 (- i 1)))) (enumerate-interval 1 n))))

(check-equal? (unique-pairs 3)
              (list
               (list 1 2)
               (list 1 3)
               (list 2 3)))
