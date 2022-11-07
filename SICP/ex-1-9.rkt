#lang sicp

#| inc, dec 구현을 확인해보자 |#
(inc 3) ; 4
(dec 5) ; 4

#| 1. recursive plus |#

; (define (+ a b)
;   (if (= a 0) b (inc (+ (dec a) b)))) ; recursive process

; 왜 recursive 인가?
; - (+ 4 5) 의 전개
;   (inc (+ 3 5))
;   (inc (inc (+ 2 5)))
;   (inc (inc (inc (+ 1 5))))
;   (inc (inc (inc (inc (+ 0 5)))))
;   (inc (inc (inc (inc 5))))
;   (inc (inc (inc 6)))
;   (inc (inc 7))
;   (inc 8)
;   9

; (+ 4 5) ; 9

#| 2. iterative plus |#

(define (+ a b)
  (if (= a 0) b (+ (dec a) (inc b))))

(+ 400000000000 5) ; 9

; 왜 iterative 인가?
; - (+ 4 5) 의 전개
;   (+ 3 6)
;   (+ 2 7)
;   (+ 1 8)
;   (+ 0 9)
;   9

; 무엇이 iterative process 이고, recursive 인지 구분하는 법
; - 이 경우에 첫번째 예시는 + 연산이 스스로를 호출할때, inc 에 nested 된 상태에서 호출했다.
;   이렇게 되면 inc 가 연결고리가 되어서 chaining 이 된다.
;   두번째 예시는 재귀호출을 top위치에서 했다.
