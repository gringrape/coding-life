#lang sicp

; # 문제 정의
; 합성저항을 구하는 프로시저를 구현한다.
; 두개의 저항이 interval로 주어질때, interval에 관한 연산을 이용해서 합성 저항을 구해야한다.
;
; 검증은 화면에 출력되는 값으로 한다.
;
; --------------- 풀이 ---------------

; ## 합성 저항
(define (composite-resistivity a b)
  (/ (* a b) (+ a b)))

(define (composite-resistivity-interval a b)
  (make-interval (composite-resistivity (lower-bound a) (lower-bound b))
                 (composite-resistivity (upper-bound a) (upper-bound b))))

; ## 데이터 표현
(define (make-interval x y) (cons x y))
(define (lower-bound interval) (car interval))
(define (upper-bound interval) (cdr interval))

; ## 출력
(define (print-interval i)
  (newline)
  (display (lower-bound i))
  (display " - ")
  (display (upper-bound i)))

(print-interval (composite-resistivity-interval (make-interval 6.12 7.48)
                                                (make-interval 4.465 4.935)))

; # 틀린 풀이 분석
; 처음에 합성 저항을 구하려는 시도가 틀렸다.
; 합성 저항을 다음과 같이 구하면 틀린 풀이가 된다.
; 왜냐하면, 인터벌의 합과 곱을 따로 구하기 때문에, 곱이 최대가 되는 저항 두쌍이 합이 최대가 되는 저항 두쌍과 다르게 된다.
;
; (define (composite-resistivity a b)
;   (div-interval (mul-interval a b)
;                 (add-interval a b)))
;
