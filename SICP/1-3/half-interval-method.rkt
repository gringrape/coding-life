#lang sicp

(define (half-interval-method f a b)
  (let ((a-value (f a)) (b-value (f b)))
    (cond ((and (negative? a-value) (positive? b-value)) (search f a b))
          ((and (positive? a-value) (negative? b-value)) (search f b a)))))

(define (search f a b)
  (let ((mid-point (average a b)))
    (if (close-enough? a b)
        mid-point
        (let ((mid-point-value (f mid-point)))
          (cond ((negative? mid-point-value) (search f mid-point b))
                ((positive? mid-point-value) (search f a mid-point)))))))

(define (average a b)
  (/ (+ a b) 2))

(define (close-enough? a b)
  (let ((tolerance 0.00001))
    (> tolerance (difference a b))))

(define (difference a b) (abs (- a b)))

(half-interval-method sin 2.0 4.0) ; 3.1415~
(half-interval-method cos 4.0 5.0) ; 4.71~

; 연습한 것
; let의 syntax
