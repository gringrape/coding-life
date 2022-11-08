#lang sicp

; 파스칼의 삼각형의 각 원소를 구하기.
; f(x, y) = f(x - 1, y - 1) + f(x, y - 1)

(define (pascal x y)
  (cond ((or (< x 0) (> x y)) 0)
        ((and (= x 0) (= y 0)) 1)
        (else (+ (pascal (dec x) (dec y))
                 (pascal x (dec y))))))

(pascal 0 0) ; 1

(pascal 0 1) ; 1
(pascal 1 1) ; 1

(pascal 0 2) ; 1
(pascal 1 2) ; 2
(pascal 2 2) ; 1

(pascal 0 3) ; 1
(pascal 1 3) ; 3
(pascal 2 3) ; 3
(pascal 3 3) ; 1
