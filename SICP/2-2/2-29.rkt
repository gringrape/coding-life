#lang sicp

(#%require rackunit)

(define (make-mobile left right)
  (list left right))

(define (make-branch weight structure)
  (list weight structure))

; #. a)

(define (left-branch mobile)
  (car mobile))

(define (right-branch mobile)
  (car (cdr mobile)))

(define (branch-length branch)
  (car branch))

(define (branch-structure branch)
  (define submobile (cdr branch))
  (if (null? (cdr submobile))
      (car submobile)
      submobile))

; #. b)

; Total weight of mobile

; ##. implementation

(define (submobile? structure)
  (pair? structure))

(define (branch-weight branch)
  (define structure (branch-structure branch))
  (if (submobile? structure)
      (total-weight structure)
      structure))

(define (total-weight mobile)
  (if (not (pair? mobile)) mobile
      (+ (branch-weight (left-branch mobile))
         (branch-weight (right-branch mobile)))))

; ## TEST

; ### CASE1. no submobile
(check-equal? (total-weight (make-mobile (make-branch 2 5)
                                         (make-branch 2 5)))
              10)

; ### CASE2. submobile
(check-equal? (total-weight (make-mobile (make-branch 2 5)
                                         (make-branch 3 (make-mobile (make-branch 2 5)
                                                                     (make-branch 2 5)))))
              15)

; #. c)

; ##. 문제 해석
; - 어떤 mobile 은 좌, 우측에 걸리는 torque 값이 동일할 때 balanced 라고 한다.
; - 각 torque 의 값은 (길이 * 무게) 로 구한다.
; - 추가적으로, mobile 의 branch 가 또 다른 mobile 이라면, sub-mobile 들도 balanced 여야 함.

(define (torque branch)
  (* (branch-length branch)
     (total-weight (branch-structure branch))))

(define (mobile? mobile)
  (pair? mobile))

(define (submobile branch)
  (branch-structure branch))

(define (balanced? mobile)
  (if (not (mobile? mobile))
      #t
      (and (balanced? (submobile (left-branch mobile)))
           (balanced? (submobile (right-branch mobile)))
           (= (torque (left-branch mobile))
              (torque (right-branch mobile))))))

; ###. CASE 1. no submobile
(check-true (balanced? (make-mobile (make-branch 2 3)
                                    (make-branch 3 2))))

; ###. CASE 2. submobile
(check-true (balanced? (make-mobile (make-branch 5 10)
                                    (make-branch 5
                                                 (make-mobile (make-branch 4 6)
                                                              (make-branch 6 4))))))

