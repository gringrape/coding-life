#lang sicp

; 1. rectangle 데이터 표현
; 1-1. 대각선 상의 두점

; (define (make-rectangle a b) (cons a b))
; (define (left-bottom rectangle) (car rectangle))
; (define (right-top rectangle) (cdr rectangle))

; (define (width rectangle)
;   (- (x-point (right-top rectangle))
;      (x-point (left-bottom rectangle))))

; (define (height rectangle)
;   (- (y-point (right-top rectangle))
;      (y-point (left-bottom rectangle))))

; 1-2. 점 네개 (왼쪽 위 부터 시계방향)
(define (make-rectangle a b c d) (cons (make-segment a b)
                                       (make-segment c d)))

(define (top-segment ractangle) (car rectangle))
(define (bottom-segment ractangle) (cdr rectangle))

(define (left-top rectangle) (start-segment (top-segment rectangle)))
(define (right-top rectangle) (end-segment (top-segment rectangle)))
(define (right-bottom rectangle) (end-segment (bottom-segment rectangle)))
(define (left-bottom rectangle) (start-segment (bottom-segment rectangle)))

(define (width rectangle)
  (- (x-point (right-top rectangle))
     (x-point (left-top rectangle))))

(define (height rectangle)
  (- (y-point (right-top rectangle))
     (y-point (right-bottom rectangle))))

; 2. segment
(define (make-segment p1 p2) (cons p1 p2))
(define (start-segment s) (car s))
(define (end-segment s) (cdr s))

; 3. point
(define (make-point x y) (cons x y))
(define (x-point p) (car p))
(define (y-point p) (cdr p))

; Area
(define (area rectangle)
  (* (width rectangle) (height rectangle)))

; Perimeter
(define (perimeter rectangle)
  (+ (* 2 (width rectangle))
     (* 2 (height rectangle))))

; Example
; 1. with end points in diagonal segment
; (define rectangleA
;   (make-rectangle (make-point 0 0)
;                   (make-point 5 6)))
;
; 2. with four points
(define rectangle
  (make-rectangle (make-point 0 5)
                  (make-point 5 6)
                  (make-point 5 0)
                  (make-point 0 0)))

; Test
(area rectangle) ; 30
(perimeter rectangle); 22
