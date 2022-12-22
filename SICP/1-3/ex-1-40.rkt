#lang sicp

; 1. newtons method 프로시저

(define (cube-root x)
  (let ((g (lambda (y) (- (cube y) x))))
    (newtons-method g 1.0)))

(define (cube x) (* x x x))

(define (newtons-method g guess)
  (fixed-point (newton-transform g) guess))

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

(define (newton-transform g)
  (lambda (x) (- x (/ (g x)
                      ((deriv g) x)))))

(define (deriv g)
  (let ((dx 0.001))
    (lambda (x) (/ (- (g (+ x dx)) (g x))
                   dx))))

(cube-root 8) ; 2
(cube-root 125) ; 5

; 2. cubic을 정의하고 방정식의 해를 구하기

(define (cubic a b c)
  (lambda (x) (+ (* x x x)
                 (* a (* x x))
                 (* b x)
                 (* c))))

(newtons-method (cubic 6 12 8) 1.0) ; -2
(newtons-method (cubic -6 12 -8) 1.0) ; 2

;
; - newtons method를 새롭게 정의하는 과정에서 헤맸다.
;   => newtos method를 fixed-point를 통해 적용하는 과정을 복기했다.
;
