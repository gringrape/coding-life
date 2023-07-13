; square-tree 프로시저 만들기
; - tree 의 모든 원소를 제곱한 새로운 트리
; - 입력 tree 의 모든 원소를 제곱한 결과의 새로운 tree

#lang sicp

(#%require rackunit)

(define (square number) (* number number))

; #. 구현
(define (tree-map function tree)
  (map (lambda (sub-tree)
         (if (pair? sub-tree)
             (tree-map function sub-tree)
             (function sub-tree)))
       tree))

(define (square-tree tree) (tree-map square tree))

; #. 테스트
; ##. sequence
(check-equal? (square-tree (list 1 2 3))
              (list 1 4 9))

; ##. tree
(check-equal? (square-tree (list 1 (list 2 3)))
              (list 1 (list 4 9)))
