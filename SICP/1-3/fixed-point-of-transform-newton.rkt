#lang sicp

(define (square-root x)
  (fixed-point-of-transform (lambda (y) (- (* y y) x))
                            newton-transform
                            1.0))

(define (fixed-point-of-transform g transform first-guess)
  (fixed-point (transform g) first-guess))

; newton transform
(define (newton-transform g)
  (lambda (x) (- x (/ (g x)
                      ((deriv g) x)))))

(define (deriv g)
  (let ((dx 0.001))
    (lambda (x) (/ (- (g (+ x dx)) (g x))
                   dx))))

; fixed-point
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

(square-root 16) ; 4

; 다음과 같이 일반화된 형식을 가진 프로시저를 생성가능.
; (define (fixed-point-of-transform g transform first-guess)
;  (fixed-point (transform g) first-guess))
