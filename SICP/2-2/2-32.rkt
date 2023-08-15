#lang sicp

(#%require rackunit)


; 목표 - complete the procedure of generating set of all subsets of a set.
; 잘 모르는 것 - 결과물을 테스트하는 법? => 배열 비교를 통해 테스트 할 수 있다.

(define (subsets s)
  (if (null? s)
      (list nil)
      (let ((rest (subsets (cdr s))))
        (append rest (map (lambda (set) (cons (car s) set)) rest)))))

; TEST

; Case 1) Empty Set
(check-equal? (subsets (list ))
              (list (list )))

; Case 2) One element
(check-equal? (subsets (list 1))
              (list (list ) (list 1)))

; Case 3) Multiple elements
(check-equal? (subsets (list 1 2))
              (list (list ) (list 2) (list 1) (list 1 2)))

; 배운 것
; - 재귀적 문제의 해결 팁 => 스스로가 이미 해결된 과제라고 가정함. => 가정했을때 전체 문제가 어떻게 쪼개지는지?
