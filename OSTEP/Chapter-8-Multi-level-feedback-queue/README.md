## 문제 1. 
시뮬레이션을 몇번 실행해보는 문제이다. 
Job의 개수와 Queue의 개수는 두개, I/O는 없다. 
다음과 같이 실행하면 된다. 이 때, seed인자를 다르게 해서 다른 시뮬레이션을 돌려준다.

```bash
python mlfq.py -j 2 -n 2 -M 0 -s 30 -c
```

## 문제 2. 
1. single long-running job
Queue는 세개로 설정할 수 있다. 
quauntum 길이와, job 의 길이를 설정할 수 있으면 된다.

```bash
python mlfq.py --jlist=0,200,0 --quantum=10 --numQueues=3 -c
```

2. along came a short job
Job을 하나 더 추가하면 된다. 
```bash
python mlfq.py --jlist=0,200,0:100,20,0 --quantum=10 --numQueues=3 -c
```

3. what about I/O
I/O frequency 와 I/O의 길이를 설정해준다. 
```bash
python mlfq.py --jlist=0,200,0:100,20,1 --quantum=10 --numQueues=3 --iotime=3 -c
```

## 문제 3. 
Queue의 개수를 하나로 하면 된다. 
```bash
python mlfq.py -j 3 -n 1 -M 0 -s 30 -c
```
