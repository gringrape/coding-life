#lang sicp

(#%require rackunit)
(#%require "enumerate-interval.rkt")
(#%require "filter.rkt")
(#%require "flatmap.rkt")
(#%require "accumulate.rkt")

(define (compatiable? position1 position2)
  (let ((x1 (car position1))
        (y1 (cadr position1))
        (x2 (car position2))
        (y2 (cadr position2)))
    (not (or (= x1 x2)
             (= y1 y2)
             (= (abs (- x1 x2)) (abs (- y1 y2)))))))

(define (every predicate elements)
  (= 0 (accumulate + 0
                   (map (lambda (element) (if (predicate element) 0 1)) elements))))

(define (safe? positions)
  (every (lambda (position) (compatiable? (car positions) position))
         (cdr positions)))

(define (adjoin-position new-row new-column positions)
  (cons (list new-row new-column) positions))

(define (queens board-size)
  (define (generate-queens queens-set new-column)
    (flatmap (lambda (rest-queens)
               (map (lambda (new-row) (adjoin-position new-row new-column rest-queens))
                    (enumerate-interval 1 board-size)))
             queens-set))
  (define (queen-cols k)
    (if (= k 0) (list '())
        (filter (lambda (positions) (safe? positions))
                (generate-queens (queen-cols (- k 1)) k))))
  (queen-cols board-size))

(check-equal? (length (queens 8)) 92)
