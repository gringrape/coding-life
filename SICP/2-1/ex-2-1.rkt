#lang sicp

(define (make-rat a b)
  (let ((g ((if (< b 0) - +) (gcd a b))))
    (cons (/ a g) (/ b g))))

(define (numer x)
  (car x))

(define (denom x)
  (cdr x))

(define (print-rat x)
  (newline)
  (display (numer x))
  (display "/")
  (display (denom x)))

; 음수 분수 표현하기
(print-rat (make-rat -6 9)) ; -1/2
(print-rat (make-rat 6 -9)) ; -1/2
(print-rat (make-rat -6 -9)) ; 1/2
