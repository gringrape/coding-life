#lang sicp

; #. 문제 분석
; - center, tolerance로 표현된 interval 구현.

; #. Test
; - print 한 결과는 양끝값으로 해서 검증.

; ##. 문제 풀이
; ###. 데이터 표현
(define (make-center-percent a b) (cons a b))
(define (center interval) (car interval))
(define (percent interval) (cdr interval))

; ###. selectors
(define (upper-bound interval)
  (+ (center interval) (tolerance interval)))

(define (lower-bound interval)
  (- (center interval) (tolerance interval)))

(define (tolerance interval)
  (* (center interval) (/ (percent interval) 100)))

; ###. Test
(define (print-interval i)
  (newline)
  (display (lower-bound i))
  (display " - ")
  (display (upper-bound i)))

(print-interval (make-center-percent 6.8 10)) ; 6.12 - 7.48
(print-interval (make-center-percent 4.7 5)) ;
