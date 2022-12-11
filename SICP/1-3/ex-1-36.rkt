#lang sicp

; 목표 정리
; - 문제에 세 가지 목표가 한꺼번에 쓰여져있어, 분리가 필요하다.
;
; 1. Modify fixed-point procedure so to print approximation value
; 2. Find the solution of equation, x ^ x = 1000
; 3. Compare the number of steps with and without average damping

; ----------------------------------------------------------------

; 1. Modify fixed-point procedure so to print approximation value

(define (fixed-point f first-guess)
  (define (try guess count)
    (report guess)
    (report count)
    (let ((next-guess (f guess)))
      (if (close-enough? guess next-guess)
          next-guess
          (try next-guess (inc count)))))
  (try first-guess 1))

(define (report value)
  (display value)
  (newline))

(define (close-enough? a b)
  (let ((tolerance 0.0001))
    (> tolerance (difference a b))))

(define (difference a b)
  (abs (- a b)))

; 2. Find the solution of equation, x ^ x = 1000
;  => f(x) = x 형태로 식을 변형.
;     x = log(1000) / log(x)

(fixed-point (lambda (x) (/ (log 1000) (log x))) 2.0)

; 3. Compare the number of steps with and without average damping

(define (average a b)
  (/ (+ a b) 2))

(fixed-point (lambda (x)
               (average x (/ (log 1000) (log x))))
             2.0)

; average damping을 사용했을 경우 총 8 단계를 거치므로,
; 29 단계를 거치는 기존과 비교해 더 빨라졌다.
