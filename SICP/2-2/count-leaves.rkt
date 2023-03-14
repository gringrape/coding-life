#lang sicp

(#%require rackunit)

; 구현 구상
; - 현재 구조가 이파리인지 페어인지 판단.
; - 페어면 재귀적으로 탐색.
; - 이파리면 카운트 추가.

(define (count-leaves node)
  (cond ((null? node) 0)
        ((not (pair? node)) 1)
        (else (+ (count-leaves (car node))
                 (count-leaves (cdr node))))))

; TEST

(define x (cons (list 1 2) (list 3 4)))

(check-equal? (count-leaves x)
              4)

(check-equal? (count-leaves (cons x x))
              8)
