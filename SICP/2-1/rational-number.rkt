#lang sicp

; 1. 1/2 를 화면에 표시하기

(define (make-rat a b)
  (let ((g (gcd a b)))
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

(define one-half (make-rat 1 2))

(print-rat one-half) ; 1/2
(newline)

; 2. 분수의 덧셈

(define (add-rat a b)
  (make-rat (+ (* (numer a) (denom b)) (* (numer b) (denom a)))
            (* (denom a) (denom b))))

(define one-third (make-rat 1 3))
(define one-fourth (make-rat 1 4))

(print-rat (add-rat one-half one-third)) ; 5/6
(print-rat (add-rat one-third one-fourth)) ; 7/12
(print-rat (add-rat one-fourth one-fourth)) ; 1/2
(newline)

; 3. 분수의 곱셈

(define (mul-rat a b)
  (make-rat (* (numer a) (numer b))
            (* (denom a) (denom b))))

(print-rat (mul-rat one-half one-third)) ; 1/6
(print-rat (mul-rat one-third one-fourth)) ; 1/12
(newline)
