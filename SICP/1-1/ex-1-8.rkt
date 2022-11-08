#lang sicp

(define (qube-root x)
  (qube-root-iter 1.0 x))

(define (qube-root-iter guess x)
  (if (good-enough guess x)
      guess
      (qube-root-iter (improve guess x) x)))

(define (good-enough guess x)
  (< (abs (- (cube guess) x)) 0.0001))

(define (improve guess x)
  (/ (+ (/ x (square guess))
        (* 2 guess))
     3))

(define (cube x) (* x x x))

(define (square y) (* y y))

(qube-root 8)

; 배운 것
; - clustering procedure의 경우. call stack 이 제공되거나,
;   테스트가 없으면 디버깅하기 힘들다.
