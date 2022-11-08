#lang sicp

(define (count-change amount) (count-change-recursive amount 5))

(define (count-change-recursive amount kinds-of-coin)
  (cond ((= amount 0) 1)
        ((or (< amount 0) (= kinds-of-coin 0)) 0)
        (else (+ (count-change-recursive amount (dec kinds-of-coin))
                 (count-change-recursive (- amount (first-denomination kinds-of-coin))
                                         kinds-of-coin)))))

(define (first-denomination kinds-of-coin)
  (cond ((= kinds-of-coin 5) 50)
        ((= kinds-of-coin 4) 25)
        ((= kinds-of-coin 3) 10)
        ((= kinds-of-coin 2) 5)
        ((= kinds-of-coin 1) 1)))

(count-change 100) ; 292


; 오류 원인
;  (count-change-recursive (- amount (first-denomination kinds-of-coin))
;                          (kinds-of-coin)))))) ; kinds of coin에 괄호를 씌우면 procedure로 해석한다.
