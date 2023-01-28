#lang sicp

; #. 문제 해석
; square-list 프로시저를 구현하라.
; - map 을 사용하여 구현
; - map 을 사용하지 않고 구현

; #. 구현
; ##. map을 사용하지 않고 구현.
; (define (square-list list)
;   (if (null? list)
;       nil
;       (cons (square (car list))
;             (square-list (cdr list)))))

; (define (square number) (* number number))

; ##. map을 사용하여 구현.
(define (square-list list)
  (map (lambda (e) (* e e)) list))

; #. 결과
(square-list (list 1 2 3 4)) ; (1 4 9 16)
