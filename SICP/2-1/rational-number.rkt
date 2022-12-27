#lang sicp

; 1. 1/2 를 화면에 표시하기

(define one-half (make-rat 1 2))

(define (make-rat a b)
  (cons a b))

(define (numer x)
  (car x))

(define (denom x)
  (cdr x))

(define (print-rat x)
  (newline)
  (display (numer x))
  (display "/")
  (display (denom x)))

(print-rat one-half) ; 1/2
