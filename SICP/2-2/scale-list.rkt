#lang sicp

(define (scale-items items factor)
  (map (lambda (item) (* item factor))
       items))

(define (map transform list)
  (if (null? list) nil
      (let ((head (car list))
            (tail (cdr list)))
        (cons (transform head)
              (map transform tail)))))

(scale-items (list 1 2 3 4) 10) ; (10 20 30 40)
