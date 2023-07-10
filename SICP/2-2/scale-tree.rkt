#lang sicp

(#%require rackunit)

; #. 정리
; - sequence 에 대한 연산인 map 을 재귀적으로 적용.
; - 재귀적 - base case, recursive case 의 두가지로 분기.

; #. map 연산 확실히 알기.
(check-equal? (map (lambda (n) (* n n))
                   (list 1 2 3 4 5))
              (list 1 4 9 16 25))

; #. 구현
(define (scale-tree tree factor)
  (map (lambda (sub-tree)
         (if (pair? sub-tree)
             (scale-tree sub-tree factor)
             (* sub-tree factor)))
       tree))

; #. 테스트
; ##. sequence
(check-equal? (scale-tree (list 1 2 3) 3)
              (list 3 6 9))

; ##. tree
(check-equal? (scale-tree (list 1 (list 2 3) 3) 3)
              (list 3 (list 6 9) 9))

(check-equal? (scale-tree (list 1 (list 2 (list 3 4) 5) (list 6 7)) 10)
              (list 10 (list 20 (list 30 40) 50) (list 60 70)))
