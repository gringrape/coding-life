#lang sicp

; # 데이터 표현
(define (make-interval x y) (cons x y))
(define (lower-bound interval) (car interval))
(define (upper-bound interval) (cdr interval))

; # 너비 프로시저
(define (width i)
  (define (half a) (/ a 2))
  (half (- (upper-bound i) (lower-bound i))))

(width (make-interval 1 7)) ; 3

; # 인터벌 합에서의 너비
; 합인터벌의 너비는 각각의 인터벌 너비를 더한 것임을 보여주면 된다.
(define (add-interval a b)
  (make-interval (+ (lower-bound a) (lower-bound b))
                 (+ (upper-bound a) (upper-bound b))))

(define interval-a (make-interval 1 5))
(define interval-b (make-interval 2 5))

(= (+ (width interval-a) (width interval-b))
   (width (add-interval interval-a interval-b))) ; true

; # 인터벌 차(subtract)에서의 너비
; 차인터벌의 너비는 두 인터벌의 너비를 뺀것과 다름을 보여주면 된다.
(define (sub-interval a b)
  (make-interval (- (lower-bound a) (upper-bound b))
                 (- (upper-bound a) (lower-bound b))))

(= (- (width interval-a) (width interval-b))
   (width (sub-interval interval-a interval-b))) ; false

; # 인터벌 곱에서의 너비
(define (mul-interval a b)
  (let ((p1 (* (upper-bound a) (upper-bound b)))
        (p2 (* (upper-bound a) (lower-bound b)))
        (p3 (* (lower-bound a) (upper-bound b)))
        (p4 (* (lower-bound a) (lower-bound b))))
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(= (* (width interval-a) (width interval-b))
   (width (mul-interval interval-a interval-b))) ; false
