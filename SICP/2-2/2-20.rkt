#lang sicp

; 같은 parity 를 가진 숫자 모으기.
; - 숫자들이 주어질때, 첫번째 숫자와 같은 parity를 가진 숫자들을 모은다.
; - dotted tail notation 을 활용한다.

(define (same-parity first . rest)
  (define (hasSameParity? number)
    (= (remainder first 2) (remainder number 2)))

  (define (collect numbers)
    (if (null? numbers) nil
        (let ((head (car numbers)) (remaining (cdr numbers)))
          (if (hasSameParity? head)
              (cons head (collect remaining))
              (collect remaining)))))

  (cons first (collect rest)))

(same-parity 1 2 3 4 5 6 7) ; (1 3 5 7)
(same-parity 2 3 4 5 6 7) ; (2 4 6)

; 발생했던 문제.
; - nil에 대해 car, cdr 연산을 사용한 것이 문제.
;  => nil 조건에 대해 early return 을 활용함.
