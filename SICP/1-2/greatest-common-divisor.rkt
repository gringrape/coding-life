#lang sicp

; Euclead Algorithm 을 통해서 GCD 구하기
; => GCD(a, b) = GCD(b, r)

(define (gcd a b)
  (if (= b 0)
      a
      (gcd b (remainder a b))))

(gcd 206 40) ; 2
(gcd 15 10) ; 5
