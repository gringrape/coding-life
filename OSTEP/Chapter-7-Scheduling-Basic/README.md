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
