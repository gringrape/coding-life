# 페르마의 소수 판별법
## 목표
- 페르마의 소수 판별법을 이용한 소수 판별 프로시져를 구현한다.

## 페르마의 소수 판별법
`p` 와 서로소이고 `p` 보다 작은 `a` 에 대하여, `p`가 소수라면 다음이 참이다. 
> (a ^ (p - 1)) % p == 1

식을 변형해보자.
> (a ^ p) % p == a

## 프로시져 구현
### 확률적 방법
페르마의 소수 판별법을 신뢰할만한 회수로 적용해서, 소수일 확률을 높이는 것이 핵심이다.
무작위로 1000번을 적용해서 모두 성공하면 소수인 것으로 정하자.
구현을 하면 다음과 같다.

```racket
(define (fast-prime? n times)
  (cond ((= times 0) true)
        ((fermat-test n) (fast-prime? n (dec times)))
        (else false)))
```

페르마의 소수 판별법을 별도의 프로시져에서 수행하자.

```racket
(define (fermat-test n)
  (define (try-it a)
    (= (expmod a n n) a))
  (try-it (+ 1 random (- n 1))))
```

여기서 `(expmod a n n)`은 `a`의 `n` 거듭제곱을 `n`으로 나눈 나머지를 구한다.
`expmod`는 `double squaring` 기법을 이용해서 빠르게 계산이 가능하다. 

```racket
(define (expmod a exp b)
  (cond ((= exp 0) 1)
        ((even? exp) (remainder (square (expmod a (/ exp 2) b))
                                b))
        (else (remainder (* a (expmod a (dec exp) b))
                         b))))
```
