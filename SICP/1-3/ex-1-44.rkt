#lang sicp

(define (n-fold-smooth f n)
  (repeated smooth n) f)

(define (repeated f n)
  (lambda (x)
    (if (> n 1)
        (f ((repeated f (dec n)) x))
        (f x))))

(define (smooth f)
  (let ((dx 0.001))
    (lambda (x) (average (f (- x dx))
                         (f x)
                         (f (+ x dx))))))

(define (average a b c)
  (/ (+ a b c) 3))
