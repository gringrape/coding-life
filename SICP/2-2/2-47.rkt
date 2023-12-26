#lang sicp

(#%require rackunit)

; 1. cons 와 list 의 차이

; Selectors for list
; - example list
(define example-list (list 1 2 3))

(check-eq? 1 (car example-list) "list - Select first element")
(check-eq? 2 (cadr example-list) "list - Select second element")
(check-eq? 3 (caddr example-list) "list - Select third element")

; Selectors for cons list
; - example cons-list
(define example-cons-list (cons 1 (cons 2 3)))

(check-eq? 1 (car example-cons-list) "cons-list - Select first element")
(check-eq? 2 (cadr example-cons-list) "cons-list - Select second element")
(check-eq? 3 (cddr example-cons-list) "cons-list - Select third element")

; 둘의 차이
; - list 는 pair 의 우항 역시 list 인 재귀적 구조.
; - cons 는 재귀적 구조가 아님.

; 2. frame 의 selectors 구현
; 2-1. list
; (define (origin-frame frame)
;   (car frame))
; (define (edge1-frame frame)
;   (cadr frame))
; (define (edge2-frame frame)
;   (caddr frame))

; 2-2. cons-list
; (define (origin-frame frame)
;   (car frame))
; (define (edge1-frame frame)
;   (cadr frame))
; (define (edge2-frame frame)
;   (cddr frame))
