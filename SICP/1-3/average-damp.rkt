#lang sicp

; average-damp 아이디어를 procedure로 표현하기.
; 제곱근을 구하는 문제를 예시로 들어서.
;
; 1. fixed-point 방법
;   fixed-point 방법은 다음과 같은 방정식을 푸는 방법.
;   f(x) = x
;   추측값을 개선해 나가는데, 현재의 추측값이 guess 라면,
;   다음은 f(guess)로 개선해 나가는 식.
;
; 2. average-damping
;   average-damping은 추측값의 개선에 관한 아이디어.
;   guess 와 f(guess)의 평균값으로 추측을 개선.
;   이 아이디어를 프로시저로 표현가능.

(define (average-damping f)
  (lambda (guess) (average guess (f guess))))

(define (average a b)
  (/ (+ a b) 2))

; 3. fixed-point 방법에 적용.

(define (square-root x)
  (fixed-point (average-damping (lambda (y) (/ x y)))
               1.0))

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

(square-root 2) ; 1.414

; 4. 세제곱근을 구하는 방법에도 적용.

(define (cube-root x)
  (fixed-point (average-damping (lambda (y) (/ x (* y y))))
               1.0))

(cube-root 27) ; 3
