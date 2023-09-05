# Server sent event

## Why use (over websocket)
- much simpler (but, one directional communication)
- auto re-connection 
- same protocol (http)

## 참고
- https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events
- https://ko.javascript.info/server-sent-events

## 실습 디자인

디자인 원칙 - 지식 수준에 맞는 과제를 설정, 모를 수록 피드백 주기를 짧고 전체 과정 자체가 짧게.

### 실습 목차
- Simple counter
- Observable

### 1 단계 
Simple counter

### RxJS 를 사용하는 예시 
https://www.freecodecamp.org/news/build-a-logging-web-app-with-server-sent-events-rxjs-and-express/

### 2 단계
Observable

주기적으로 이벤트를 생성해서 결과를 출력하는 예제.
이벤트의 발생과 발생 후의 행동을 `분리`하는 RxJS 사용. 

-> 
