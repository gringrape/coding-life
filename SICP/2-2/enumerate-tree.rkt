#lang sicp

(#%require rackunit)

; Procedure
(define (enumerate-tree tree)
  (cond ((null? tree) nil)
        ((not (pair? tree)) (list tree))
        ((pair? tree) (append (enumerate-tree (car tree))
                              (enumerate-tree (cdr tree))))))

; Test
(check-equal? (enumerate-tree nil) nil)

(check-equal? (enumerate-tree (list 1)) (list 1))

(check-equal? (append (list 1) (list 2 3)) (list 1 2 3))

(check-equal? (enumerate-tree (list (list 1 2) 3)) (list 1 2 3))

(check-equal? (enumerate-tree (list 1 (list 2 3) 4)) (list 1 2 3 4))

(check-equal? (enumerate-tree (list (list 1 2) (list 3 4) 5)) (list 1 2 3 4 5))

(#%provide enumerate-tree)
