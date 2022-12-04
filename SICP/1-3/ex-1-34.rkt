#lang sicp

(define (f g)
  (g 2))

(define (square x) (* x x))

(f square)

(f (lambda (x) (+ x 1)))

; what if I put f in the place of g
(f f)

; Answer.
; (f f) => (f 2) => (2 2) => 2 is not procedure
