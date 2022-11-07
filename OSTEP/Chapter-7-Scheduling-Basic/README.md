## 1번 문제 
길이가 200인 세개의 Job이 주어질때, reponse time, turnaround time의 평균을 계산하라. 정책이 FIFO 인 경우와 SJF인 경우 각각 계산하라.

- FIFO인 경우
  - turnaround time: (200 + 400 + 600) / 3 = 400
  - response time: (0 + 200 + 400) / 3 = 200
- SJF인 경우 - 동일하다.

정책이 FIFO인 경우, 답은 다음과 같이 확인 할 수 있다.
```bash
python ./scheduler.py -p FIFO -l 200,200,200 -c
```

정책이 SJF인 경우에는 인자를 수정해 주면 된다. 
```bash
python ./scheduler.py -p SJF -l 200,200,200 -c
```

## 2번 문제
1번과 같은 조건이지만 Job의 길이가 100, 200, 300인 경우에 각 지표를 구하여라. 

- turnaround time: SJF, FIFO 둘 모두 333.333 으로 같다. 
```bash
python ./scheduler.py -p FIFO -l 100,200,300 -c
```
- response time: SJF, FIFO 둘 모두 133.333 으로 같다. 
```bash
python ./scheduler.py -p SJF -l 100,200,300 -c
```

## 3번 문제
1, 2 번과 같지만 정책을 Round Robin으로 하고 time slice의 길이를 1로 했을때,
각 지표의 값을 구하여라.

### 풀이
Round Robin에서 중요한 것이 각 slice의 길이이다. 이 길이가 너무 긴 경우에는
사실상 종료될때까지 실행하는 것과 같아지고, 너무 작은 경우에는 context switching의 비용이
얻는 이득에 비해 과도하게 된다. 

해석 프로그램에서 slice의 길이를 어떻게 지정하는지 확인해보자.
```bash
python scheduler.py -h
```

slice의 길이는 해석 프로그램에서 다음과 같이 지정할 수 있다.
```bash
python scheduler.py -p RR -l 100,200,300 -q 1 -c
```

결과는 쉽게 예측할 수 있다. 응답시간은 각각 0, 1, 2이므로 평균을 구하면 1이 된다.
`turnaround time`의 경우, 첫번째 Job이 완료될때까지 세개의 Job을 모두 균등하게 실행하므로, 
첫번째는 300이 된다. 그다음 Job의 경우는 남은 길이가 100이고 두개의 Job이 함께 실행되므로, 
200이 된다. 마지막은 100이 된다. 따라서, 평균은 다음과 같이 구할 수 있다.

```
(300 + 200 + 100) / 3
```

해석 결과 
![](https://user-images.githubusercontent.com/53764714/200163872-8af1800d-8f15-4e65-8695-0483ec4ab5a1.png)

## 4번 문제
어떤 종류의 `workload`에서 `SJF`와 `FIFO`의 `turnaround time`이 같아지는가?

### 풀이
가장 짧은 작업이 가장 먼저 오게 되는 경우에 두 정책은 같아진다.
즉, Job들의 길이가 오름차순일때, turnaround time이 같아진다.

## 5번 문제
어떤 종류의 `workload`와 `quantum length`에서 `SJF`와 `RR`은 같아지는가?

### 풀이
전체 Job의 개수를 N이라고 하고, 길이 순으로 보았을때,
N-1번째 Job의 길이보다 `quantum length`가 같거나 커야 한다. 
`context switching`이 일어나지 않아야 하기 때문이다.

## 6번 문제
SJF에서 Job의 길이가 증가할때, `response time`은 어떻게 되는가?
simulator를 사용해 경향을 파악해볼 수 있는가?

### 풀이 
linear 하게 증가 할 것이다.
Simulator를 다음과 같이 실행해보자.
```bash
python scheduler.py -p SJF -l 100,200,300 -c
python scheduler.py -p SJF -l 200,300,400 -c
python scheduler.py -p SJF -l 300,400,500 -c

```
133, 233, 333 으로 100씩 증가한다.

## 7번 문제
`Round Robin` 정책을 사용하는 경우, `quantum length`가 증가 할때,
`response time`은 어떻게 되는가? Job의 개수가 N개라고 할때, 최악의
`response time`에 대한 등식을 세울수 있는가?

### 풀이
`quantum length`가 증가하는 경우에 `response time`은 증가한다. `context switching`이 덜 일어나기 때문이다. 최악의 경우란 `context switching`이 전혀 일어나지 않고 하나의 slice당 한개의 Job이 처리되는 것이다.

따라서, 평균을 계산하면 다음과 같다. 
```
response-time = average(1 to n) * quantum-length
```
