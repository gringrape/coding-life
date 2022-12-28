#lang sicp

; 1. 1/2 를 화면에 표시하기

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

(define one-half (make-rat 1 2))

(print-rat one-half) ; 1/2

; 2. 분수의 덧셈

(define (add-rat a b)
  (let ((new-denom (lcm (denom a) (denom b))))
    (make-rat (+ (* (numer a) (/ new-denom (denom a)))
                 (* (numer b) (/ new-denom (denom b))))
              new-denom)))

(define one-third (make-rat 1 3))
(define one-fourth (make-rat 1 4))

(print-rat (add-rat one-half one-third)) ; 5/6
(print-rat (add-rat one-third one-fourth)) ; 7/12
