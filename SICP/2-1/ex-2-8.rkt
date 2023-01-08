#lang sicp

; # 데이터 표현
(define (make-interval x y)
  (cons x y))

(define (lower-bound interval)
  (car interval))

(define (upper-bound interval)
  (cdr interval))

; # 출력
(define (print-interval p)
  (newline)
  (display (lower-bound p))
  (display " - ")
  (display (upper-bound p)))

; # 뺄셈 프로시저
(define (sub-interval a b)
  (make-interval (- (lower-bound a) (upper-bound b))
                 (- (upper-bound a) (lower-bound b))))

(print-interval (sub-interval (make-interval 5 9)
                              (make-interval 2 4))) ; 1 - 7
