#lang sicp

(#%require rackunit)
(#%require "accumulate.rkt")
(#%require "2-36.rkt")

; 1. Simple dot product
; 1-1. implementation
(define (dot-product u v)
  (accumulate + 0 (map * u v)))

; 1-2. tests
(check-equal? (dot-product (list 1 2 5)
                           (list 2 6 8))
              54)

; 2. matrix * vector
; 2-1. implementation
(define (matrix-*-vector m v)
  (map (lambda (row) (dot-product row v)) m))

; 2-2. tests
(define mat (list (list 1 2)
                  (list 3 4)))

(define vec (list 5 6))

(check-equal? (matrix-*-vector mat vec)
              (list 17 39))

(define mat-2 (list (list 1 2 4)
                    (list 3 4 5)
                    (list 2 7 9)))

(define vec-2 (list 5 6 8))

(check-equal? (matrix-*-vector mat-2 vec-2)
              (list
               (+ (* 1 5) (* 2 6) (* 4 8))
               (+ (* 3 5) (* 4 6) (* 5 8))
               (+ (* 2 5) (* 7 6) (* 9 8))
               ))

; 3. transpose
(define (transpose matrix)
  (accumulate-n cons nil matrix))

(check-equal? (transpose (list (list 1 2)
                               (list 3 4)))
              (list (list 1 3)
                    (list 2 4)))

(check-equal? (transpose (list
                          (list 1 2 3)
                          (list 3 4 5)
                          (list 5 6 7)
                          ))
              (list
               (list 1 3 5)
               (list 2 4 6)
               (list 3 5 7)
               ))

; 4. matrix * matrix
(define (matrix-*-matrix m n)
  (let ((rows m) (cols (transpose n)))
    (map (lambda (row)
           (map (lambda (col)
                  (dot-product row col))
                cols))
         rows)))

(check-equal? (matrix-*-matrix
               (list
                (list 1 2 3)
                (list 3 4 5)
                (list 5 6 7)
                )
               (list
                (list 1 3 5)
                (list 2 4 6)
                (list 3 5 7)
                ))
              (list
               (list 14 26 38)
               (list 26 50 74)
               (list 38 74 110)
               ))

