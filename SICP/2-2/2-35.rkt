#lang sicp

(#%require rackunit)

(#%require "accumulate.rkt")
; (#%require "enumerate-tree.rkt")

; (define (count-leaves tree)
;   (accumulate
;    (lambda (b a) (inc a))
;    0
;    (enumerate-tree tree)))


(define (count-leaves tree)
  (accumulate +
              0
              (map (lambda (x)
                     (if (pair? x)
                         (count-leaves x)
                         1))
                   tree)))

; TEST
(check-equal? (count-leaves nil) 0)

(check-equal? (count-leaves (list 1 2 3)) 3)

(check-equal? (count-leaves (list (list 1 2) 3)) 3)
(check-equal? (count-leaves (list (list 1 2 3 5) (list 1 2) 1)) 7)
