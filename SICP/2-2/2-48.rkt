#lang sicp

; - 나의 풀이.
; (define (make-segment start-segment end-segment)
;   (cons start-segment end-segment))

; (define (start-segment segment) (car segment))
; (define (end-segment segment) (cdr segment))

; - 사실, 위에서 make-segment 를 잘 지켜보면 cons 와 같은 것을 확인할 수 있다.
; - 어떤 문제든 본질적이고 심플한 해가 반드시 존재한다.
; - 모든 문제의 진실, 진짜 답을 찾아나서자.

(define make-segment cons)
(define start-segment  car)
(define end-segment  cdr)
