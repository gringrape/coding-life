#lang sicp

; 황금비는 다음의 등식을 만족하는 미지수 x
;
;   x^2 = x + 1
;
; 여기서 양변을 x로 나눌 수 있다.
;
;   x = 1 + 1 / x
;
; 따라서, x = f(x) 형태가 되므로, fixed-point 방법을 적용해볼 수 있다.
; 그 전에, 연속적으로 x를 업데이트 해보면 oscillation이 일어나지는 않는다.
;

(define (fixed-point f first-guess)
  (define (try guess)
    (let ((next-guess (f guess)))
      (if (close-enough? guess next-guess)
          next-guess
          (try next-guess))))
  (try first-guess))

(define (close-enough? a b)
  (let ((tolerance 0.00001))
    (> tolerance (difference a b))))

(define (difference a b)
  (abs (- a b)))

(fixed-point (lambda (x) (+ 1.0 (/ 1.0 x))) 1.0)
