#lang sicp

; sum을 iterative하게 구현하기
; 상태가 업데이트되는 식으로 구현하면 된다.

(define (sum term a next b)
  (define (iter a result)
    (if (> a b)
        result
        (iter (next a) (+ result (term a)))))
  (iter a 0))

(define (sum-integers a b)
  (sum identity a inc b))

(sum-integers 1 10) ; 55
(sum-integers 1 100) ; 5050
