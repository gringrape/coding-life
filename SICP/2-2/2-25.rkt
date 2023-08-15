#lang sicp

(#%require rackunit)

(define (sevenExists? numbers)
  (cond
    ((null? numbers) #f)
    ((not (pair? numbers)) (= 7 numbers))
    (else (or (sevenExists? (car numbers))
              (sevenExists? (cdr numbers))))))

(check-equal? (sevenExists? (list 1 2 3 4 7))
              #t)

(check-equal? (sevenExists? (list 1 7 3 4 2 4 5))
              #t)

(check-equal? (sevenExists? (list 2 4 8))
              #f)

(check-equal? (sevenExists? (list 1 3 (list 5 7) 9))
              #t)

(check-equal? (sevenExists? (list (list 7)))
              #t)

(check-equal? (sevenExists? (
                             cons 1 (cons 2 (cons 3 (cons 4 (cons 5 (cons 6 7)))))))
              #t)
