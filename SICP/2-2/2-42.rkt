#lang sicp

(#%require rackunit)
(#%require "enumerate-interval.rkt")
(#%require "filter.rkt")
(#%require "accumulate.rkt")
(#%require "flatmap.rkt")

; 1. list 의 길이를 알 수 있다.
(check-equal? (length (list 1 2 3)) 3)
(check-equal? (length (list 1 2 3 4 5)) 5)



; 3. 코드 작성 및 각 부분에 대한 이해
(define empty-board '())

; 두개의 위치가 compatible 해야 한다.
(define (compatiable? position1 position2)
  (and (not (= (car position1) (car position2)))
       (not (= (cadr position1) (cadr position2)))
       (not (= (abs (- (car position1) (car position2)))
               (abs (- (cadr position1) (cadr position2)))))))

(define (safe? k positions)
  (= 0 (accumulate + 0
                   (map
                    (lambda (position) (if (compatiable? (car positions) position) 0 1)) (cdr positions)))))

(define (adjoin-position row column queens)
  (cons (list row column) queens))

; k 번째 칼럼만 안전한지 확인하면 됨.
; - 문자 그대로 같은 row 에 누가 있는지?
; - 대각선에 누가 있는지?
; - 행이나 대각선의 합이 2 이상

(define (queens-fake board-size)
  (define (queens-cols k)
    (if (= k 0)
        (list empty-board) ; 재귀에서 base 조건, empty board 가 뭐지? nil 인가?
        (filter
         (lambda (positions) (safe? k positions)) ; k 번째 칼럼에 위치한 퀸이 안전한지를 확인한다
         (flatmap ; flatmap 의 대상은 (queen-cols (- k 1)) 이다. 즉, 각각이 퀸들의 배치(position)가 된다.
          (lambda (rest-of-queens) ; k-1 개의 queen 을 첫번째 k-1 개의 칼럼에 배치하는 방법이라고 함.
            (map (lambda (new-row) ; new-row 라고 부르는 것에 주의하자. 새로운 칼럼에 배치하는데 row 위치는 0 부터 board-size(정사각형, n by n)까지 될 수 있다.
                   (adjoin-position
                    new-row k rest-of-queens))
                 (enumerate-interval 1 board-size)))
          (queens-cols (- k 1))))))
  (queens-cols board-size))

; 2. eight-queens 문제에 대한 테스트를 구성함.
(define (queens board-size)
  (enumerate-interval 0 91))

(check-equal? (length (queens-fake 8)) 92)
