#lang sicp

(#%require "accumulate.rkt")

(define (flatmap proc sequence)
  (accumulate append nil (map proc sequence)))

(#%provide flatmap)
