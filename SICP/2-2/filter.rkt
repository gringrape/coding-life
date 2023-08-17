#lang sicp

(#%require rackunit)

(define (filter predicate sequence)
  (cond ((null? sequence) nil)
        ((predicate (car sequence))
         (cons (car sequence)
               (filter predicate (cdr sequence))))
        (else (filter predicate (cdr sequence)))))

display

(check-equal? (filter odd? nil)
              nil)

(check-equal? (filter odd? (list 1 2 3 4 5))
              (list 1 3 5))

(check-equal? (filter even? (list 1 2 3 4 5))
              (list 2 4))
