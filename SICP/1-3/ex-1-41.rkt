#lang sicp

; Define a procedure,
; that takes a procedure of one argument as argument
; and returns a procedure that applies original procedure twice.

(define (double f)
  (lambda (x) (f (f x))))

((double inc) 1) ; 3

(((double (double double)) inc) 5) ; 21
