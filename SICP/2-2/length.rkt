#lang sicp

(#%require rackunit)

(define (length tree)
  (if (null? tree)
      0
      (+ 1 (length (cdr tree)))))

; TEST

(check-equal?
 (length(list 1 2 3 4 5))
 5)

(check-equal?
 (length (cons (list 1 2) (list 3 4)))
 3)
