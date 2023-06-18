#lang sicp

(#%require rackunit)

(define (make-mobile left right)
  (list left right))

; a.
; a-1. left-branch
(define (left-branch mobile)
  (car mobile))

; a-2. right-branch
(define (right-branch mobile)
  (car (cdr mobile)))

; a-3. branch-length
(define (branch-length branch)
  (car branch))

; a-4. branch-structure
(define (branch-structure branch)
  (car (cdr branch)))

; b.
; total weight of mobile
; => select structure
;  - if leave, + weight
;  - if pair, + weight of structure
;  - if null, 0

; implementation
(define (total-weight mobile)
  (+ (branch-structure (left-branch mobile))
     (branch-structure (right-branch mobile))))

; TEST
(define branch-a (list 2 5))

(define mobile (make-mobile branch-a branch-a))

(check-equal? (total-weight mobile) 10)

; structure 가 또 다른 mobile 인 경우.
