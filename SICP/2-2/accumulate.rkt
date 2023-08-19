#lang sicp

(#%require rackunit)

; Implementation
(define (accumulate operation initial sequence)
  (if (null? sequence)
      initial
      (operation (car sequence)
                 (accumulate operation initial (cdr sequence)))))

; Test
(check-equal? (accumulate + 0 nil) 0)

(check-equal? (accumulate + 1 (list 2)) 3)

(check-equal? (accumulate + 1 (list 2 4 5)) 12)

; learned
; - 가장 단순한 케이스를 작성하는 것에는 의미가 있다.
; - 문제를 해결하는 보폭은 신경을 쓰지 않는다면 커진다.
; - 재귀적 사고방식의 핵심은 이미 문제가 해결되었다고 가정할때, 작은 부분으로 쪼개는 것.
;   (이 다음은 내 알바 아니다라는 태도가 중요함.)

(#%provide accumulate)
