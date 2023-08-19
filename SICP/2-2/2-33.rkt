#lang sicp

(#%require rackunit)
(#%require "accumulate.rkt")

; 1. map
(define (map-custom operation sequence)
  (accumulate (lambda (x y) (cons (operation x) y)) nil sequence))

(check-equal? (map-custom (lambda (x) (* 3 x)) (list 1 2 3))
              (list 3 6 9))

(check-equal? (map-custom (lambda (x) (* x x)) (list 1 2 3))
              (list 1 4 9))

; 2. append
(define (append-custom sequence1 sequence2)
  (accumulate cons sequence2 sequence1))

(check-equal? (append-custom (list 1 2 3) (list 4 5 6))
              (list 1 2 3 4 5 6))

; 3. length
(define (length-custom sequence)
  (accumulate (lambda (x y) (inc y)) 0 sequence))

(check-equal? (length-custom (list 1 2 3)) 3)
