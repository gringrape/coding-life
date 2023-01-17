# RabbitMQ
## 목표
- 메시지 큐에 메시지를 보낸다. 
- 메시지 큐에서 메시지를 받는다. 

## 진행
`RabbitMQ` 이미지 실행. 

```shell
docker pull rabbitmq
docker run -d -p 5672:5672 -p 15672:15672 rabbitmq
```

메시지가 잘 들어오는지 확인하기 위한 준비를 한다. 
```shell
docker exec -it <container_id> /bin/bash
```

몇 개의 메시지가 큐에 들어있는지를 확인 할 수 있다. 
```shell
rabbitmqctl list_queues
```

```shell
npm start
```

실행 성공. 

```bash
> start
> node src/index.js

message server is connected!
message sended: Hello, RabbitMQ
```

메시지 확인

```bash
```

## JavaScript 프로젝트 설정 
### Dependencies
- ESLint
- AMQP https://www.npmjs.com/package/amqplib

## 오류 기록
### 프로토콜 오류
`http` => `amqp`
```
    throw new Error("Expected amqp: or amqps: as the protocol; got " + protocol);
          ^

Error: Expected amqp: or amqps: as the protocol; got http:
```
### Socket closed while handshaking
```
    bail(err || new Error('Socket closed abruptly ' +
                ^

Error: Socket closed abruptly during opening handshake
```

docker 실행시 port 설정을 바꾸어 보자. 

### 보낸 메시지가 보이지 않는 현상
포트 지정. 

```
docker run -d -p 5672:5672 -p 15672:15672 --hostname my-rabbit --name some-rabbit rabbitmq
```
