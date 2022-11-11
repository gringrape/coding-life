## 문제 1.

Compute the solutions for simulations with 3 jobs and random seeds of 1, 2 and 3.

```
python lottery.py -s 1
python lottery.py -s 2
python lottery.py -s 3
```

## 문제 2.

Now run with two specific jobs: each of length 10, but one(job 0)
with just 1 ticket and the other(job 1) with 100(e.g. -1 10:1,10:100).
What happens when the number of tickets is so imbalacned? Will
job 0 ever run before job 1 completes? How often? In general, what
does such a ticket imbalance do to the behavior of lottery scheduling?

다음과 같이 실행할 수 있다.
```
python lottery.py -l 10:1,10:100 -c -s 5
```

job 1이 완료될때까지 CPU를 독점하는 것을 관찰 할 수 있었다.
job 0는 거의 실행되지 못한다. 
