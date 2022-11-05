#lang sicp

; 처음에는 cond의 경우에는 조건이 만족하지 않아도,
; 각 결과가 평가될거라 생각해서 무한 호출이 된다고 생각했다.
; 하지만 책 24p 아래 부분에서, cond의 경우도 조건이 맞는 경우에만 평가가 이루어진다고 해서
; 동작할 것 같다.
;
; 동작하지 않는다. 이유는 new-if를 호출하는 과정에 있는 것 같다.
; cond문과는 관계없이 피연산자의 평가가 우선적으로 이루어져야 하기 때문에(applicative order interpreter)
; square-root-iter의 호출이 정상적으로 끝나지 않는다.
;
; new-if 는 다음과 같이 구성가능하다.
(define (new-if predicate consequent alternative)
  (cond ((predicate) (consequent))
        (else alternative)))

(define (square-root x)
  (square-root-iter 1.0 x))

(define (square-root-iter guess x)
  (new-if (good-enough guess x)
          guess
          (square-root-iter (improve guess x) x)))

(define (good-enough guess x)
  (< (abs (- (square guess) x)) 0.001))

(define (improve guess x)
  (average guess (/ x guess)))

(define (square x) (* x x))

(define (average x y) (/ (+ x y) 2))

(square-root 4) ; 2
(square-root 2) ; 1.414...
