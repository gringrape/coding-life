#lang sicp

; 기본전략
; - 핵심은 cdring down

; 1. basic list
(list 1 2 3)

; 2. list-ref
(define (list-ref list index)
  (if (= 0 index)
      (car list)
      (list-ref (cdr list) (- index 1))))

(list-ref (list 1 2 3) 1) ; 2

; 3. length
(define (length list)
  (if (null? list)
      0
      (inc (length (cdr list)))))

(length (list 1 2 3 4 5)) ; 5

; 4. append
(define (append list1 list2)
  (if (null? list1)
      list2
      (cons (car list1) (append (cdr list1) list2))))

(append (list 1 2 3) (list 4 5 6)) ; (1, 2, 3, 4, 5, 6)
