#lang sicp

(define (p) (p))
(define (test x y)
  (if (= x 0) x y))

; 문제. 위와 같이 procedure 를 정의하고,
; (test 0 (p)) 를 evaluation 한다고 했을때,
; applicative order를 따르는 interpreter와
; normal order를 따르는 interpreter에서
; 결과의 차이가 어떻게 나타날지 생각해보자.

; 답.
;
; 1. normal order를 따를때.
;   normal order는 필요할때까지 피연산자(operands)의 평가(evaluation)를 최대한 미룬다는 것이 특징이다.
;   (test 0 (p))는 대체 모델(substitution model)에 따라서,
;   (if (= 0 0) 0 (p)) 가 된다.
;   if는 특수한 형태(special form)이므로 조건(predicate)을 먼저 검사하고,
;   결과에 따라서 result나 alternative 중 무엇을 evaluation할지 결정한다.
;   따라서 해석 결과는 다음과 같이 된다.
;
;   (test 0 (p)) => (if (= 0 0) 0 (p)) => (if #t 0 (p)) => 0
;   마지막 순서에서 alternative 부분을 평가하지 않는 것에 주목하자.
;
; 2. applicative order를 따를때,
;   applicative order는 연산자와 피연산자를 먼저 evalution하고
;   그 결과에 연산을 적용하는 것이 특징이다.
;   따라서, 주어진 procedure는 다음과 같은 순서로 평가 된다.
;   (test 0 (p)) => (test 0 (p)) => (test 0 (p)) => ...
;   즉, 평가가 끝나지 않게 된다.

; 책 원문 참고.
; - normal order -> don't evaluate operand until their value is needed
; - applicative order -> first evaluate operator and operands
;   (operator 부분도 compound expression 일 수 있음.)
;   and apply resulting operator to resulting operands.
