#lang sicp

; newtons method를 활용하는 fixed-point 방법으로 해결.

; fixed-point 프로시저
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

; newton-transform, g -> x - g / (deriv g)
(define (newton-transform g)
  (lambda (x) (- x (/ (g x)
                      ((deriv g) x)))))

(define (deriv g)
  (let ((dx 0.001))
    (lambda (x) (/ (- (g (+ x dx)) (g x))
                   dx))))

; 제곱근을 구하는 예제
(define (square-root x)
  (let ((g (lambda (y) (- (square y) x))))
    (fixed-point (newton-transform g) 1.0)))

(define (square x) (* x x))

(square-root 9) ; 3
(square-root 16) ; 4

; 세 제곱근을 구하는 예제
(define (cube-root x)
  (let ((g (lambda (y) (- (cube y) x))))
    (fixed-point (newton-transform g) 1.0)))

(define (cube x) (* x x x))

(cube-root 8) ; 2
(cube-root 125) ; 5

; 제곱근과 세제곱근을 구하는 문제에서 달라진것은, g 프로시저 밖에 없음.
