#lang sicp
; 문제 설명
;
; - 선분의 중점을 계산하는 문제.
; - 선분, 점 각각의 데이터 프로시저에 대한 contructor, selector 이름이 주어짐.
; - 이름을 통해서 데이터 프로시저를 구현하고 이를 이용해 중점 프로시저를 만드는 문제.
;
; 풀이 계획
;
; 1. 하나의 점 출력하기.
;   - 점 출력 프로시저
;   - point 데이터 설계
; 2. 중점을 출력하기.
;   - 중점 프로시저 인터페이스
;   - segement 데이터 설계


; 풀이
;
; 1. 하나의 점 출력하기
;  완료조건: (print-point (make-point 2 3)) 의 결과가 화면에 (2,3)으로 출력되면 완료.

; a. 점출력 프로시저
(define (print-point p)
  (newline)
  (display "(")
  (display (x-point p))
  (display ",")
  (display (y-point p))
  (display ")"))

; b. 점 데이터 설계 -> constructor, selector
(define (make-point x y) (cons x y))

(define (x-point p) (car p))
(define (y-point p) (cdr p))

(print-point (make-point 2 3)) ; (2,3)

; 2. 중점을 출력하기
; b. segment 데이터 설계
(define (make-segment p1 p2)
  (cons p1 p2))

(define (start-segment s) (car s))
(define (end-segment s) (cdr s))

; a. 중점 프로시저 인터페이스
;   예시는 (1, 2) 와 (3, 2) 의 중점이 (2, 2) 인 것.
(define (midpoint-segment segment)
  (let ((p1 (start-segment segment))
        (p2 (end-segment segment)))
    (make-point (average (x-point p1)
                         (x-point p2))
                (average (y-point p1)
                         (y-point p2)))))

(define (average a b)
  (/ (+ a b) 2))

(print-point (midpoint-segment (make-segment (make-point 1 2)
                                             (make-point 3 2)))) ; (2, 2)

(print-point (midpoint-segment (make-segment (make-point 9 25)
                                             (make-point 33 81)))) ; (17, 53)
