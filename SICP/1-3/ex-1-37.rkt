#lang sicp

(define (cont-frac-recursive n d k)
  (define (iterate i)
    (/ (n i) (+ (d i) (if (< i k)
                          (iterate (inc i))
                          0))))
  (iterate 1))

; 황금비
(cont-frac-recursive (lambda (i) 1.0)
                     (lambda (i) 1.0)
                     1000) ; 0.6180

(define (cont-frac-iterative n d k)
  (define (iterate i sum)
    (if (= i 0)
        sum
        (iterate (dec i) (/ (n i) (+ sum (d i))))))
  (iterate k 0.0))

(cont-frac-iterative (lambda (i) 1.0)
                     (lambda (i) 1.0)
                     1000) ; 0.6180
