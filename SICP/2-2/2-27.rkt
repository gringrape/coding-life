#lang sicp

(#%require rackunit)

; 1. reverse

(define (reverse numbers)
  (define (reverse-iter forward backward)
    (if (null? forward)
        backward
        (reverse-iter (cdr forward)
                      (cons (car forward)
                            backward))))
  (reverse-iter numbers nil))

(check-equal? (reverse (list 1 2 3 4))
              (list 4 3 2 1))

; 2. deep-reverse

(define (deep-reverse numbers)
  (define (reverse-iter forward backward)
    (if (null? forward)
        backward
        (reverse-iter (cdr forward)
                      (cons (deep-reverse (car forward)) backward))))
  (if (pair? numbers)
    (reverse-iter numbers nil)                
    numbers
  ))

(check-equal? (deep-reverse (list (list 1 2) (list 3 4)))
              (list (list 4 3) (list 2 1)))
