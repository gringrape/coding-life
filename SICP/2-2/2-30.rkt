#lang sicp

(#%require rackunit)

; #. 문제 해석
; - square-tree 의 구현.
; - 첫번째 풀이, higher order function 을 이용하지 않기.
; - 두번째 풀이, map 을 재귀적으로 적용해서 풀이.

; #. 구현
(define (square number) (* number number))

; ## 1. no higher order function
; (define (square-tree tree)
;   (cond ((null? tree) nil)
;         ((not (pair? tree)) (square tree))
;         (else (cons (square-tree (car tree))
;                     (square-tree (cdr tree))))))

; ## 2. recursive map
(define (square-tree tree)
  (map (lambda (sub-tree)
         (if (pair? sub-tree)
             (square-tree sub-tree)
             (square sub-tree)))
       tree))

; #. 테스트
; ##. case-1. sequence
(check-equal? (square-tree (list 1 2 3))
              (list 1 4 9))

; ##. case-2. tree
; (check-equal? (square-tree (list 1 (list 2 3) 4))
;               (list 1 (list 4 9) 16))
