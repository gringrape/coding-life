#lang sicp

(define (search-for-primes start count)
  (start-search start count 0)
  (newline))

(define (start-search number count searchCount)
  (define (go)
    (timed-prime-test number)
    (start-search (inc number)
                  count
                  (if (prime? number)
                      (inc searchCount)
                      searchCount)))
  (if (< searchCount count)
      (go)))

(define (timed-prime-test n)
  (start-prime-test n (runtime)))

(define (start-prime-test n start-time)
  (if (prime? n) (report-time (- (runtime) start-time))))

(define (report-time elapsed-time)
  (display " *** ")
  (display elapsed-time))

(define (prime? n)
  (= (smallest-divisor n) n))

(define (smallest-divisor n)
  (find-divisor n 2))

(define (find-divisor n test-divisor)
  (cond ((> (square test-divisor) n) n)
        ((divides? n test-divisor) test-divisor)
        (else (find-divisor n (inc test-divisor)))))

(define (square n)
  (* n n))

(define (divides? a b)
  (= (remainder a b) 0))

(search-for-primes 1000 3)
(search-for-primes 100000 3)
(search-for-primes 10000000 3)
(search-for-primes 1000000000 3)
(search-for-primes 100000000000 3)
(search-for-primes 10000000000000 3)
