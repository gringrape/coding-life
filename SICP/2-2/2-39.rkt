#lang sicp

(#%require rackunit)

; fold-right


(check-equal? (reverse (list 1 2 3 4))
              (list 4 3 2 1))
