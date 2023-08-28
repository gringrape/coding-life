#lang sicp

(#%require rackunit)

(check-equal? 1 1)

(define (fold-left operation initial sequence)
  (define (iter result rest)
    (if (null? rest)
        result
        (iter (operation result (car rest))
              (cdr rest))))
  (iter initial sequence))

(check-equal? (fold-left + 0 (list 1 2 3 4)) 10)
