#lang sicp

; fixex-point

(define (fixed-point-of-transform g transform guess)
  (fixed-point (transform g) guess))

(define (average-damping f)
  (lambda (guess) (average guess (f guess))))

(define (average a b)
  (/ (+ a b) 2))

(define (fixed-point f first-guess)
  (define (try guess)
    (let ((next-guess (f guess)))
      (if (close-enough? guess next-guess)
          next-guess
          (try next-guess))))
  (try first-guess))

(define (close-enough? a b)
  (let ((tolerance 0.00001)) (> tolerance (difference a b))))

(define (difference a b)
  (abs (- a b)))

; repeated
(define (repeated f n)
  (lambda (x)
    (if (> n 1)
        (f ((repeated f (dec n)) x))
        (f x))))

; ------ experiment ------
; 1. square root

(define (square-root x)
  (fixed-point-of-transform (lambda (y) (/ x y))
                            (repeated average-damping 1) ; 필요한 횟수 1
                            1.0))

; => 결론 (2, 1)

; 2. cubic root

(define (cubic-root x)
  (fixed-point-of-transform (lambda (y) (/ x (* y y)))
                            (repeated average-damping 1) ; 필요한 횟수 1
                            1.0))

; 3. fourth root

(define (fourth-root x)
  (fixed-point-of-transform (lambda (y) (/ x (* y y y)))
                            (repeated average-damping 2) ; 필요한 횟수 2
                            1.0))

; 결론 (4, 2)

; 4. fifth root

(define (fifth-root x)
  (fixed-point-of-transform (lambda (y) (/ x (* y y y y)))
                            (repeated average-damping 2) ; 필요한 횟수 2
                            1.0))

; 결론 (5, 2)

; 5. 일반화된 식
(define (experiment n k)
  (let ((x (pow 2 n)))
    (fixed-point-of-transform (lambda (y) (/ x (pow y (dec n))))
                              (repeated average-damping k) ; 필요한 횟수 2
                              1.0)))

(define (pow x n)
  (if (> n 0)
      (* x (pow x (dec n)))
      1))

; (n, k)

; (experiment 2 1)
; (experiment 3 1)

; (experiment 4 2)
; (experiment 5 2)
; (experiment 6 2)
; (experiment 7 2)

; (experiment 8 3)
; (experiment 15 3)

; (experiment 16 4)
; (experiment 31 4)

; 일반화 된 프로시저
(define (nth-root x n)
  (let ((k (floor (/ (log n) (log 2)))))
    (fixed-point-of-transform (lambda (y) (/ x (pow y (dec n))))
                              (repeated average-damping k) ; 필요한 횟수 2
                              1.0)))

(nth-root 1024 10) ; 2
(nth-root 4096 12) ; 2

(nth-root 3486784401 20) ; 3
