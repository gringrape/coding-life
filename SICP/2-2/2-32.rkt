#lang sicp

(#%require rackunit)


; sort

; - take smaller, larger
(define (take-smaller pivot l)
  (cond ((null? l) nil)
        ((<= pivot (car l)) (take-smaller pivot (cdr l)))
        (else (append (list (car l)) (take-smaller pivot (cdr l))))))

(define (take-larger pivot l)
  (cond ((null? l) nil)
        ((>= pivot (car l)) (take-larger pivot (cdr l)))
        (else (append (list (car l)) (take-larger pivot (cdr l))))))


(check-equal? (take-smaller 2 (list 2 1 3))
              (list 1))

(check-equal? (take-smaller 3 (list 1 2 3))
              (list 1 2))

(check-equal? (take-smaller 1 (list 1 2))
              nil)

(check-equal? (take-larger 1 (list 2 1))
              (list 2))

(check-equal? (take-larger 2 (list 3 1 2))
              (list 3))

; - quick sort
(define (quick-sort l)
  (if (or (= (length l) 1) (null? l)) l
      (append (quick-sort (take-smaller (car l) l))
              (list (car l))
              (quick-sort (take-larger (car l) l)))))


(define (sort list)
  (quick-sort list))

(check-equal? (sort (list 1))
              (list 1))

(check-equal? (sort nil) nil)

(check-equal? (quick-sort (list 2 1 3)) (list 1 2 3))
(check-equal? (quick-sort (list 3 1 2)) (list 1 2 3))
(check-equal? (quick-sort (list 3 1 2 5)) (list 1 2 3 5))

(define (subsets set)
  (if (null? set)
      (list nil)
      (append (subsets (cdr set))
              (map (lambda (s) (sort (append (list (car set)) s)))
                   (subsets (cdr set)))
              )))

; TEST

; empty list
(check-equal? (subsets nil)
              (list nil))

; one element
(check-equal? (subsets (list 1))
              (list nil (list 1)))

; two elements
(check-equal? (subsets (list 1 2))
              (list nil (list 2) (list 1) (list 1 2)))
