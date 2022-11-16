#lang sicp

(define (prime? n)
  (fast-prime? n 100))

(define (fast-prime? n times)
  (cond ((= times 0) true)
        ((fermat-test n) (fast-prime? n (dec times)))
        (else false)))

(define (fermat-test n)
  (define (try-it a)
    (= (expmod a n n) a))
  (try-it (+ 1 (random (- n 1)))))

(define (expmod a exp b)
  (cond ((= exp 0) 1)
        ((even? exp) (remainder (square (expmod a (/ exp 2) b))
                                b))
        (else (remainder (* a (expmod a (dec exp) b))
                         b))))

(define (square n) (* n n))

(prime? 141959) ; true
(prime? 141980) ; false
