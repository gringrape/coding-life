#lang sicp

; count-change procedure의 order of growth 계산하기.

; 풀이
; 1. number of steps
;
; (cc n 1) = (+ (cc n 0) (cc (- n 1) 1)) = (+ 1 (cc (- n 1) 1)) => O(n) 이 된다.
; (cc n 2) = (+ (cc n 1) (cc (- n 5) 2)) => O(n * (5 / n)) => O(n^2) 이 된다.
;
; 따라서 O(n^5)이 number of steps 의 order of growth이다.
;
; 2. number of space
;
; 꼬리재귀가 아니고, n 단계이므로 총 n개의 공간을 소모한다.
;

