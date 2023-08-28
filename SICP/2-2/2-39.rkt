#lang sicp

(#%require rackunit)

; fold-right
(define (fold-right operation initial sequence)
  (if (null? sequence)
      initial
      (operation (car sequence)
                 (fold-right operation initial (cdr sequence)))))

(check-equal? (fold-right + 0 (list 1 2 3 4)) 10)

(define (reverse-using-right sequence)
  (fold-right (lambda (x y) (append y (list x)))
              nil sequence))

(check-equal? (reverse-using-right (list 1 2 3 4))
              (list 4 3 2 1))

(check-equal? (reverse-using-right (list 1 2 3 4 5))
              (list 5 4 3 2 1))

; fold-left
(define (fold-left operation initial sequence)
  (define (iter result rest)
    (if (null? rest) result
        (iter (operation result (car rest))
              (cdr rest))))
  (iter initial sequence))

(check-equal? (fold-left + 0 (list 1 2 3 4)) 10)

(define (reverse-using-left sequence)
  (fold-left (lambda (x y) (cons y x)) nil sequence))

(check-equal? (reverse-using-left (list 1 2 3 4))
              (list 4 3 2 1))

(check-equal? (reverse-using-left (list 1 2 3 4 5))
              (list 5 4 3 2 1))
