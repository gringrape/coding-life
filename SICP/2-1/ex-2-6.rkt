#lang sicp

; 구하는 것.
; - one, two 을 직접 구현하기
; - 덧셈을 직접 구현하기

(define zero (lambda (f) (lambda (x) x)))

(define (add-1 n)
  (lambda (f) (lambda (x) (f ((n f) x)))))

; substitution
;
; one => (add-1 zero)
; => (lambda (f) (lambda (x) (f ((zero f) x))))
; => (lambda (f) (lambda (x) (f x))))
;
; two => (add-1 one)
; => (lambda (f) (lambda (x) (f ((one f) x))))
; => (lambda (f) (lambda (x) (f (f x)))
;
; 즉, 합성 함수 구조를 가짐.
; three => (f (f (f x)))
; four  => (f (f (f (f x))))

(define one (lambda (f) (lambda (x) (f x))))
(define two (lambda (f) (lambda (x) (f (f x)))))

; 덧셈
; - 덧셈 예시
(define three
  (lambda (f) (lambda (x) ((two f) ((one f) x)))))

; - 덧셈 일반식
(define (add a b)
  (lambda (f) (lambda (x) ((a f) ((b f) x)))))

; substitution
; three => (lambda (f)
;            (lambda (x)
;              ((lambda (x) (f (f x))) (f x)))))
;       => (lambda (f)
;            (lambda (x)
;              ((f (f (f x))))))
