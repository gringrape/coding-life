#lang sicp

(#%require rackunit)

(define (enumerate-interval from to)
  (if (> from to)
      nil
      (cons from (enumerate-interval (inc from) to))))

; Test

(check-equal? (enumerate-interval 2 1) nil)

(check-equal? (enumerate-interval 2 2) (list 2))

(check-equal? (enumerate-interval 2 3) (list 2 3))

(check-equal? (enumerate-interval 1 5) (list 1 2 3 4 5))

; learned

; - CTRL+Z 를 봉인하자.
; - 잘못했을때 처음 부터 다시 만들게 되니, 자연스렙게 차분해졌다.

(#%provide enumerate-interval)
