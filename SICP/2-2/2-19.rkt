#lang sicp

; #. 문제 해석
; 금액과 denomination 이 주어질때, denomination을 이용하여 금액을
; 거슬러 주는 방법의 수.

; ##. 풀이
; ###. count-changes
(define (count-changes amount coin-values)
  (cond ((= amount 0) 1)
        ((or (< amount 0) (no-more? coin-values)) 0)
        (else (+ (count-changes amount (except-first coin-values))
                 (count-changes (- amount (first-denomination coin-values)) coin-values)))))

(define (no-more? list) (null? list))
(define (except-first coin-values) (cdr coin-values))
(define (first-denomination coin-values) (car coin-values))

; ###. Test
(define us-coins (list 50 25 10 5 1))

(count-changes 100 us-coins) ; 292
