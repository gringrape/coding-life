#lang sicp

; 목표
; - 저수준 데이터인 cons, car, cdr 프로시저를 구현해본다.
; 과제의 의미
; - cons, car, cdr 이 갖춰야할 조건은 한쌍의 데이터(Pair)라는 개념을 옳게 표현하는 것이다.
; - Pair를 옳게 표현하는 것이 cons, car, cdr의 '요건'이 된다.
; - 이 요건을 만족하는 어떤 프로시저라도(굳이, cons, car, cdr이 아니라도) Pair라는 데이터를 표현할 수 있게 된다.
; 검증방법
; - 분수 데이터를 저수준 데이터로 작성해보고, 표현 결과를 검증한다.

; ------------------------------------------------------------------

; cons, car, cdr 구현
(define (cons a b)
  (lambda (x) (cond ((= x 0) a)
                    ((= x 1) b)
                    (else (error "Argument not 0 or 1: CONS" x)))))

(define (car z) (z 0))
(define (cdr z) (z 1))

; rational number represantation
(define (make-rat numer denom)
  (cons numer denom))

(define (numer number)
  (car number))

(define (denom number)
  (cdr number))

; print out
(define (print-rat number)
  (newline)
  (display (numer number))
  (display "/")
  (display (denom number)))

; TEST
(print-rat (make-rat 3 4)) ; 3/4

; TEST error
(define (pair x) ((cons 1 2) x))
(pair 2)


; -------------------------------------------------------------------------
; 구현 포인트
; - 생성자의 반환값이 프로시저라는 것이 구현 포인트
; - 오류 처리
