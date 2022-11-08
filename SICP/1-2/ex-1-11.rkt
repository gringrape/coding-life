#lang sicp

; 계획
; - recursive => iterative

(define (f-recursive n)
  (if (< n 3)
      n
      (+ (f-recursive (- n 1))
         (* 2 (f-recursive (- n 2)))
         (* 3 (f-recursive (- n 3))))))

(define (f-iterative n)
  (f-iterate n 0 1 2))

(define (f-iterate n a b c)
  (if (= n 0)
      a
      (f-iterate (- n 1)
                 b
                 c
                 (+ (* 3 a) (* 2 b) c))))

(f-recursive 4) ; 11
(f-iterative 4) ; 11

(f-recursive 7) ; 142
(f-iterative 7) ; 142
