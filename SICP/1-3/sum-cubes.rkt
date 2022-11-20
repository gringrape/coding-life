#lang sicp

(define (sum-cubes a b)
  (if (= a b)
      (cube a)
      (+ (cube a) (sum-cubes (inc a) b))))

(define (cube x) (* x x x))

(sum-cubes 1 4) ; 1 + 8 + 27 + 64 = 100
