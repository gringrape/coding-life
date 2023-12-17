#lang sicp

; dummy
(define (below f g) f)
(define (beside f g) f)

(define (up-split painter n)
  (if (= n 0)
      painter
      (let ((smaller (up-split painter (- n 1))))
        (below painter (beside smaller smaller)))))
