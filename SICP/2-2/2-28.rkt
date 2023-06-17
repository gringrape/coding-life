#lang sicp

(#%require rackunit)

; fringe
; - 구하는 것 - tree 구조에서 leaves 를 모아놓은 list
(define (fringe tree)
  (if (null? tree)
      nil
      (let ((head (car tree)) (tail (cdr tree)))
        (if (pair? head)
            (append (fringe head) tail)
            (cons head (fringe tail))))))


; CASE1. tree 가 leaves 로만 구성되는 경우.
(check-equal? (fringe (list 1 2 3 4))
              (list 1 2 3 4))

; CASE2. tree 가 또 다른 tree 로 구성되는 경우.
(check-equal? (fringe (list (list 1 2) 3 4))
              (list 1 2 3 4))

(check-equal? (fringe (list (list 1 2 (list 3 4)) 3 4))
              (list 1 2 3 4 3 4))

(check-equal? (append (list 1 2 3 4) (list 5 6))
              (list 1 2 3 4 5 6))
