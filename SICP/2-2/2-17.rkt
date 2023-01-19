#lang sicp

; #. 풀이 계획
; list = (cons head tail)
; tail이 nil 인경우에 list를 반환하면 된다.

(define (last-pair list)
  (let ((tail (cdr list)))
    (if (null? tail)
        list
        (last-pair tail))))

; # Test
(last-pair (list 1 2 3 100)) ; (100)
(last-pair (list 23 72 149 34)) ; (34)
