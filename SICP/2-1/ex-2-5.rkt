#lang sicp

; 정수와 연산자만을 사용해서 Pair를 표현하기.
; (1, 3) => 2^1 * 3^3 = 54
; 54 로 pair (1, 3) 의 정보를 담을 수 있음.

(define (pow x y)
  (if (= y 0)
      1
      (* x (pow x (dec y)))))

(define (cons a b)
  (* (pow 2 a) (pow 3 b)))

(define (car x)
  (count-divisions x 2))

(define (cdr x)
  (count-divisions x 3))

(define (count-divisions a b)
  (define (iter x count)
    (if (divides? x b)
        (iter (/ x b) (inc count))
        count))
  (iter a 0))


(define (divides? a b)
  (= (remainder a b) 0))

; TEST
(cons 1 3) ; 54
(car 54) ; 1
(cdr 54) ; 3

; TEST 2
(cons 3 4) ; 648
(car 648) ; 3
(cdr 648) ; 4
