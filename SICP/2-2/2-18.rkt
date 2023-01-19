#lang sicp

; #. 풀이 해설
; 정방향 배열의 head를 떼어서 역방향 배열의 head로 붙여나가면 된다.

(define (reverse list)
  (define (reverse-iter forward reversed)
    (if (null? forward)
        reversed
        (reverse-iter (cdr forward)
                      (cons (car forward) reversed))))
  (reverse-iter list nil))

(reverse (list 1 2 3 4)) ; (4 3 2 1)
