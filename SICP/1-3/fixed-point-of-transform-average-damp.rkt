#lang sicp

; 제곱근 문제
(define (square-root x)
  (fixed-point-of-transform (lambda (y) (/ x y))
                            average-damping
                            1.0))

(define (square x) (* x x))

(define (fixed-point-of-transform g transform guess)
  (fixed-point (transform g) guess))

(define (average-damping f)
  (lambda (guess) (average guess (f guess))))

(define (average a b)
  (/ (+ a b) 2))

(define (fixed-point f first-guess)
  (define (try guess)
    (let ((next-guess (f guess)))
      (if (close-enough? guess next-guess)
          next-guess
          (try next-guess))))
  (try first-guess))

(define (close-enough? a b)
  (let ((tolerance 0.00001)) (> tolerance (difference a b))))

(define (difference a b)
  (abs (- a b)))

(square-root 4) ; 2
