#lang sicp

; 문제 분석
; - 구하는 것: for-each 프로시저 구현.
; - for-each 프로시저: list 의 각 원소마다 연산을 적용 해준다.

; 풀이 구상
; - 결과를 생성하지 않는 재귀 프로시저 생성.

; 구현
(define (for-each procedure items)
  (if (null? items)
      true
      (and (procedure (car items))
           (for-each procedure (cdr items)))))

; TEST
(for-each (lambda (x)
            (newline)
            (display x))
          (list 10 30 20))
