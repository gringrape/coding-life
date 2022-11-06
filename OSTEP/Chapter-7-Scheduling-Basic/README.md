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
