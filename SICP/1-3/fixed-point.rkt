#lang sicp

; f(x) = x 를 만족하는 x를 찾는 문제.
; x의 추정값을 guess라고 하면, 이를 f(guess)로 개선가능.
; 이전값과 다음값의 차이가 충분히 작아질때까지 추정값을 개선 하는 것이 핵심.

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

(fixed-point cos 1.0) ; 0.739082...

; f(y) = sin(y) + cos(y) 에 대한 fixed-point 찾기.

(fixed-point
 (lambda (y) (+ (sin y) (cos y)))
 1.0) ; 1.25...
