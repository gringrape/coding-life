#lang sicp

; #. 검증할 것
; 수학적인 예상 값과 실제 프로시저 연산값이 달라지는 것.
; ##. 나눗셈 검증

(define (make-interval x y) (cons x y))
(define (lower-bound interval) (car interval))
(define (upper-bound interval) (cdr interval))

(define (mul-interval a b)
  (let ((p1 (* (upper-bound a) (upper-bound b)))
        (p2 (* (upper-bound a) (lower-bound b)))
        (p3 (* (lower-bound a) (upper-bound b)))
        (p4 (* (lower-bound a) (lower-bound b))))
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(define (width i)
  (define (half a) (/ a 2))
  (half (- (upper-bound i) (lower-bound i))))

(define (div-interval a b)
  (if (= (width b) 0) (error "cannot divided by zero span interval"))
  (mul-interval a (make-interval (/ 1.0 (upper-bound b))
                                 (/ 1.0 (lower-bound b)))))

; ##. A / A
(define A (make-interval 1 3))
(define B (make-interval 1 3))

; ##. A / B
(div-interval A A) ; 1, 1
(div-interval A B) ; 0.3333, 3

; 문제 원인
; - 같은 인터벌끼리 나눠도 구간계산을 한다.
; - 하나의 인터벌 A가 사용되었다면, 다른 인터벌 A는 확정적이어야 한다.
