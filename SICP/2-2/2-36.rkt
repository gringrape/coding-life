#lang sicp

(#%require rackunit)
(#%require "accumulate.rkt")

(define (accumulate-n operation initial sequences)
  (if (null? (car sequences))
      nil
      (cons (accumulate operation initial (map car sequences))
            (accumulate-n operation initial (map cdr sequences)))))

(check-equal? (accumulate-n + 0 (list (list 1)
                                      (list 4)
                                      (list 7)
                                      (list 10)))
              (list 22))

(check-equal? (accumulate-n + 0 (list (list 1 2 3)
                                      (list 4 5 6)
                                      (list 7 8 9)
                                      (list 10 11 12)))
              (list 22 26 30))

; map
(check-equal? (map car (list (list 1 2 3)
                             (list 4 5 6)
                             (list 10 11 12)))
              (list 1 4 10))
(check-equal? (map cdr (list (list 1 2 3)
                             (list 4 5 6)
                             (list 10 11 12)))
              (list (list 2 3) (list 5 6) (list 11 12)))

(#%provide accumulate-n)
