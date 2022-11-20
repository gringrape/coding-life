#lang sicp

(define (sum-integers a b)
  (if (= a b)
      a
      (+ a (sum-integers (inc a) b))))

(sum-integers 1 10) ; 55
