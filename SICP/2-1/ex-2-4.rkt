#lang sicp

; 1. Verify that (car (cons x y)) yields x.
; 1-1. by example

(define (cons x y)
  (lambda (m) (m x y)))

(define (car z)
  (z (lambda (p q) p)))

(car (cons 10 100)) ; 10

; 1-2. by substitution model

; (car (cons x y))
;
; (cons x y) 부분을 대체
; => (car (lambda (m) (m x y)))
;
; (car f) 대입
; => ((lambda (m) (m x y)) (lambda (p q) p))
;
; 좌측 프로시저 인수에 우측 프로시저 대입
; => ((lambda (p q) p) x y)
;
; 람다식에 인수 대입
; => x

; 2. Define cdr corresponding to definition of cons, car
(define (cdr z)
  (z (lambda (p q) q)))

(cdr (cons 10 100)) ; 100
