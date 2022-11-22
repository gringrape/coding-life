#lang sicp

(define (filtered-accumulate filter combiner null-value term a next b)
  (if (> a b)
      null-value
      (combiner (if (filter a) (term a) null-value)
                (filtered-accumulate filter combiner null-value term (next a) next b))))

; a) sum of squared prime numbers

(define (sum-prime-squared a b)
  (filtered-accumulate prime? + 0 square a inc b))

(define (prime? n)
  (define (iter k)
    (cond ((> k (sqrt n)) true)
          ((divides? n k) false)
          (else (iter (inc k)))))
  (iter 2))

(define (divides? n k) (= (remainder n k) 0))

(define (square x) (* x x))


(sum-prime-squared 2 5) ; 38
(sum-prime-squared 4 11) ; 195

; b) n 보다 작고 n 과 서로소인 모든 수의 곱

(define (product-relatively-prime-and-less-than n)
  (filtered-accumulate (relatively-prime? n) * 1 identity 2 inc n))

(define (relatively-prime? n)
  (define (relative-prime-with-n k) (= (gcd k n) 1))
  relative-prime-with-n)

(product-relatively-prime-and-less-than 10) ; 189
(product-relatively-prime-and-less-than 16) ; 2027025
