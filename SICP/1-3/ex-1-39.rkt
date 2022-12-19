#lang sicp

(define (tan-approximate x)
  (cont-frac (lambda (i) (if (> i 1) (* x x) x))
             (lambda (i) (- (* 2 i) 1))
             1000))

(define (cont-frac n d k)
  (define (iterate i)
    (/ (n i) (- (d i) (if (< i k)
                          (iterate (inc i))
                          0))))
  (iterate 1))

(tan-approximate 1.0467) ; 1.730
(tan-approximate 0.523) ; 0.5766
