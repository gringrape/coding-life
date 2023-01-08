#lang sicp

; 할 일
; # 문제의 요구사항
; interval의 데이터 표현 프로시저를 완성 시켜야 한다.
;
; 추가적으로, 완성된 데이터 표현 프로시저와 인터벌 연산을 이용해 합성 저항을 구해 볼 수 있다.
; 여기서는 합성 저항을 구하는 것은 제외하고 데이터 표현 프로시저만을 구현해보자.
;
; 풀이 검증은 콘솔에 표시되는 값으로 한다.
; 검증을 위해 인터벌을 표시하는 프로시저를 구현해 주어야 한다.

; -------- 풀이 ---------
; 1. 데이터 표현
(define (make-interval x y)
  (cons x y))

(define (lower-bound interval)
  (car interval))

(define (upper-bound interval)
  (cdr interval))

; 2. 콘솔에 출력
(define (print-interval p)
  (newline)
  (display (lower-bound p))
  (display " - ")
  (display (upper-bound p)))

(print-interval (make-interval 2.58 2.97)) ; 2.58 - 2.97
