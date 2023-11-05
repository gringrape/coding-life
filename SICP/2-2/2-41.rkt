#lang sicp

(#%require rackunit)
(#%require "enumerate-interval.rkt")
(#%require "flatmap.rkt")
(#%require "accumulate.rkt")
(#%require "filter.rkt")

; 문제 정의
; - n 보다 작고 서로 다른 세 개의 수 중에서 합이 s 가 되는 쌍들을 구하기.

; 단계 나누기
; - 숫자 interval 만들기
; - 숫자쌍 배열 만들기
; - 세 숫자상 배열 만들기
; -

; 1. 숫자 interval 만들기
; - import 를 어떻게 했더라? => require vs provide

(check-equal?
 (enumerate-interval 1 3)
 (list 1 2 3))

; 2. 숫자쌍 배열 만들기
(check-equal?
 (map (lambda (x) (list x (inc x))) (enumerate-interval 1 3))
 (list (list 1 2) (list 2 3) (list 3 4)))

(check-equal?
 (flatmap (lambda (i)
            (map (lambda (j) (list j i))
                 (enumerate-interval 1 (- i 1))))
          (enumerate-interval 1 3))
 (list (list 1 2)
       (list 1 3)
       (list 2 3)))

; 3. 세숫자쌍 배열 만들기
(check-equal?
 (flatmap (lambda (i)
            (flatmap (lambda (j)
                       (map (lambda (k) (list k j i))
                            (enumerate-interval 1 (- j 1))))
                     (enumerate-interval 1 (- i 1))))
          (enumerate-interval 1 4))
 (list
  (list 1 2 3)
  (list 1 2 4)
  (list 1 3 4)
  (list 2 3 4)))

(define (sum list)
  (accumulate + 0 list))

(define (find-triples summation limit)
  (filter (lambda (pair) (= (sum pair) summation))
          (flatmap (lambda (i)
                     (flatmap (lambda (j)
                                (map (lambda (k) (list k j i))
                                     (enumerate-interval 1 (- j 1))))
                              (enumerate-interval 1 (- i 1))))
                   (enumerate-interval 1 limit)))
  )

(check-equal?
 (find-triples 6 10)
 (list (list 1 2 3)))
