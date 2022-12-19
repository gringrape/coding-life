#lang sicp

(define (approximate-e)
  (+ 2 (cont-frac (lambda (i) 1.0)
                  (lambda (i) (if (= (remainder i 3) 2)
                                  (* (+ (quotient i 3) 1) 2)
                                  1))
                  1000)))

(define (cont-frac n d k)
  (define (iterate i)
    (/ (n i) (+ (d i) (if (< i k)
                          (iterate (inc i))
                          0))))
  (iterate 1))

(approximate-e) ; 2.718281828
