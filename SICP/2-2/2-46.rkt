#lang sicp

(#%require rackunit)

; 목표
; - make-vect
; - xcor-vect
; - ycor-vect

(define (make-vect x y) (cons x y))

(define (xcor-vect vector) (car vector))
(define (ycor-vect vector) (cdr vector))

(check-equal? (xcor-vect (make-vect 1 2)) 1)
(check-equal? (ycor-vect (make-vect 1 2)) 2)

; 목표
; add-vect
; sub-vect
; scale-vect

; add-vect
(define (add-vect vector1 vector2)
  (let (
        (x1 (xcor-vect vector1))
        (y1 (ycor-vect vector1))
        (x2 (xcor-vect vector2))
        (y2 (ycor-vect vector2)))
    (make-vect (+ x1 x2) (+ y1 y2))))

(check-equal? (add-vect
               (make-vect 1 2)
               (make-vect 2 3))
              (make-vect 3 5))

; sub-vect
(define (sub-vect vector1 vector2)
  (let (
        (x1 (xcor-vect vector1))
        (y1 (ycor-vect vector1))
        (x2 (xcor-vect vector2))
        (y2 (ycor-vect vector2)))
    (make-vect (- x1 x2) (- y1 y2))))

(check-equal? (sub-vect
               (make-vect 1 2)
               (make-vect 2 3))
              (make-vect -1 -1))

; scale-vect
(define (scale-vect m vector)
  (let ((x1 (xcor-vect vector))
        (y1 (ycor-vect vector)))
    (make-vect (* m x1) (* m y1))))

(check-equal? (scale-vect 3 (make-vect 1 2))
              (make-vect 3 6))

(#%provide make-vect)
