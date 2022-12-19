#lang sicp

(define (display-sequence a k)
  (define (iterate i)
    (display (a i))
    (newline)
    (if (< i k) (iterate (inc i))))
  (iterate 1))

(display-sequence (lambda (i) (if (= (remainder i 3) 2)
                                  (* (+ (quotient i 3) 1) 2)
                                  1))
                  10)
