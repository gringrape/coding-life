#lang sicp

(define (assert-equals message a b)
  (if (not (equal? a b))
      (error message)))

(define (length tree)
  (if (null? tree)
      0
      (+ 1 (length (cdr tree)))))

(assert-equals "트리의 길이"
               (length(list 1 2 3 4 5))
               5)
(assert-equals "트리의 길이"
               (length (cons (list 1 2) (list 3 4)))
               3)
