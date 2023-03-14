#lang sicp

(#%require rackunit)

(define (count-leaves tree)
  (cond ((null? tree) 0)
        ((not (pair? tree)) 1)
        (else (+ (count-leaves (car tree))
                 (count-leaves (cdr tree))))))

; TEST

(define x (cons (list 1 2) (list 3 4)))

(check-equal? (count-leaves x)
              4)

(check-equal? (count-leaves (cons x x))
              8)
