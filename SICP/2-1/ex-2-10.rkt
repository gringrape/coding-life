#lang sicp

; # 문제 해석
; 인터벌의 나눗셈에서 길이가 0인 인터벌로 나누는 것은 의미가 없다.
; 이 경우를 체크하고 에러를 던져야 한다.

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

; # 나눗셈
(define (width i)
  (define (half a) (/ a 2))
  (half (- (upper-bound i) (lower-bound i))))

(define (div-interval a b)
  (if (= (width b) 0) (error "cannot divided by zero span interval"))
  (mul-interval a (make-interval (/ 1.0 (upper-bound b))
                                 (/ 1.0 (lower-bound b)))))

(div-interval (make-interval 1 3)
              (make-interval 1 1)) ; error
