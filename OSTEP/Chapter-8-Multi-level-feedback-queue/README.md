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

4. starvation
Job을 하나 더 추가하고, I/O가 일어나는 두개의 Job의 길이를 100으로 만들어,
I/O가 일어나지 않는 작업이 실행되지 않는 starvation 상황을 만든다. 

I/O가 발생한 이후에도 우선순위가 유지되도록 stay option도 준다.

```bash
python mlfq.py \
  --jlist=0,200,0:100,200,1:100,200,1 \
  --quantum=10 \
  --numQueues=3 \
  --iotime=1 \
  --stay \
  -c
```

5. boost
starvation 을 막도록 20ms 가 지나면 boost 할 수 있는 option을 설정해준다.

```bash
python mlfq.py \
  --jlist=0,200,0:100,100,1:100,100,1 \
  --quantum=10 \
  --numQueues=3 \
  --iotime=1 \
  --boost=20 \
  --stay \
  -c
```

6. with gaming tolerance
stay option을 설정해서 interactive job의 우선순위가 내려가지 않도록 한다. 

```bash
python mlfq.py \
  --jlist=0,200,0:100,100,3 \
  --quantum=10 \
  --numQueues=3 \
  --iotime=1 \
  --stay \
  -c
```

7. with gaming tolerance
queue의 allotment를 10으로 설정해서 interactive job도 우선순위가 내려가도록 한다. 

```bash
python mlfq.py \
  --jlist=0,200,0:100,100,3 \
  --quantum=10 \
  --numQueues=3 \
  --iotime=1 \
  -a 10 \
  -c
```

8. lower priority, longer quantum
우선순위가 내려갈 수록 slice의 길이를 길게 해준다. 

```bash
python mlfq.py \
  --jlist=0,200,0:0,200,0 \
  --quantumList=10,20,30 \
  --numQueues=3 \
  -c
```


## 문제 3. 
Queue의 개수를 하나로 하면 된다. 
```bash
python mlfq.py -j 3 -n 1 -M 0 -s 30 -c
```
