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

## 문제 3. 
When running with two jobs of length 100 and equal ticket allocations
of 100 (-l 100:100, 100:100), how unfair is the scheduler? 
Run with some different random seeds to determine the answer, let unfairness
be determined by how much earlier one job finishes than the other.

### 풀이
seed 값을 변경해가면서 fairness 수치를 기록해보자. 

```
python lottery.py -l 100:100,100:100 -c -s 1
```

s = 1 => F = 196/200 = 0.98
s = 2 => F = 190/200 = 0.95
s = 3 => F = 196/200 = 0.98
s = 4 => F = 199/200 = 0.99

Fairness가 1에 가까워서 거의 균등하게 배분되는것을 확인할 수 있다.
시간길이에 따라서 평균적 Fairness가 달라지므로 이것도 확인해보는 것이 좋겠다. 


