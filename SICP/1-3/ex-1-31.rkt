#lang sicp

(define (product term a next b)
  (if (> a b)
      1
      (* (term a) (product term (next a) next b))))

; 1. factorial 계산하기

(define (factorial n)
  (product identity 1 inc n))

(factorial 3) ; 6
(factorial 4) ; 24

; 2. Pi 계산하기

(define (pi)
  (* 4 (product term-pi 3.0 inc-double 1000000)))

(define (term-pi k)
  (* (/ (dec k) k)
     (/ (inc k) k)))

(define (inc-double k)
  (+ k 2))

(pi) ; 3.14...

; 3. product 프로시저를 iterative process를 만들도록 바꾸기(꼬리재귀)

(define (multiply-range a b)
  (product-iter identity a inc b))

(define (product-iter term a next b)
  (define (iter n result)
    (if (> n b) result (iter (next n) (* result (term n)))))
  (iter a 1))

(multiply-range 2 5) ; 120
(multiply-range 5 8) ; 1680
