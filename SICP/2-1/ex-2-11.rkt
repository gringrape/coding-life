#lang sicp

; ## 문제 해석
; 곱하려는 구간들의 끝점 부호를 검사하자.
; 그러면, 구간 곱셈이 끝점 부호에 따라 9 가지 경우의 수로 나눠진다.

; ## 경우의 수 나열
; 일단 하나의 구간에서 나올 수 있는 끝점 부호 경우의 수.
; 세가지이다. => (- -), (- +), (+ +)
; 두개의 구간을 곱하므로 경우의 수는 9가지

; ## 문제 풀이
; ### 데이터 표현
(define (make-interval x y) (cons x y))
(define (lower-bound interval) (car interval))
(define (upper-bound interval) (cdr interval))

; ### 출력
(define (print-interval p)
  (newline)
  (display (lower-bound p))
  (display " - ")
  (display (upper-bound p)))

; ### 곱셈 프로시저
(define (mul-interval multiplicand multiplier)
  (let ((a (lower-bound multiplicand))
        (b (upper-bound multiplicand))
        (c (lower-bound multiplier))
        (d (upper-bound multiplier)))
    (cond
      ((and (both-positive? a b) (both-positive? c d))
       (make-interval (* a c) (* b d)))
      ((and (both-positive? a b) (zero-crossing? c d))
       (make-interval (* b c) (* b d)))
      ((and (both-positive? a b) (both-negative? c d))
       (make-interval (* b c) (* a d)))

      ((and (zero-crossing? a b) (both-positive? c d))
       (make-interval (* a d) (* b d)))
      ((and (zero-crossing? a b) (zero-crossing? c d))
       (make-interval (min (* a d) (* b c)) (max (* a c) (* b d))))
      ((and (zero-crossing? a b) (both-negative? c d))
       (make-interval (* b d) (* a c)))

      ((and (both-negative? a b) (both-positive? c d))
       (make-interval (* a d) (* b c)))
      ((and (both-negative? a b) (zero-crossing? c d))
       (make-interval (* a d) (* a c)))
      ((and (both-negative? a b) (both-negative? c d))
       (make-interval (* b d) (* a c))))))

(define (both-positive? a b) (and (positive? a) (positive? b)))
(define (zero-crossing? a b) (and (negative? a) (positive? b)))
(define (both-negative? a b) (and (negative? a) (negative? b)))

; ### Test
(print-interval (mul-interval (make-interval 1 2)
                              (make-interval 3 5))) ; 3, 10
(print-interval (mul-interval (make-interval -5 4)
                              (make-interval 3 5))) ; -25, 20
(print-interval (mul-interval (make-interval -5 -4)
                              (make-interval 3 5))) ; -25, -12
