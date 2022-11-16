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
  (if (prime? n) (report-time n (- (runtime) start-time))))

(define (report-time number elapsed-time)
  (display " ")
  (display number)
  (display " *** ")
  (display elapsed-time))

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

(search-for-primes 1000 3)
(search-for-primes 100000 3)
(search-for-primes 10000000 3)
(search-for-primes 1000000000 3)
