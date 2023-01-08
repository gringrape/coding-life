#lang sicp

(define (make-interval x y) (cons x y))
(define (lower-bound interval) (car interval))
(define (upper-bound interval) (cdr interval))

(define (add-interval a b)
  (make-interval (+ (lower-bound a) (lower-bound b))
                 (+ (upper-bound a) (upper-bound b))))

(define (mul-interval a b)
  (let ((p1 (* (upper-bound a) (upper-bound b)))
        (p2 (* (upper-bound a) (lower-bound b)))
        (p3 (* (lower-bound a) (upper-bound b)))
        (p4 (* (lower-bound a) (lower-bound b))))
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(define (div-interval a b)
  (mul-interval a (make-interval (/ 1.0 (upper-bound b))
                                 (/ 1.0 (lower-bound b)))))
