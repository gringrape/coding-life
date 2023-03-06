# Tetris
## 프로젝트 초기화
sbt - https://www.scala-sbt.org/
scalaTest - https://www.scalatest.org/install
scalaTest FunSuite - https://www.scalatest.org/user_guide/selecting_a_style

## Indigo
설치 - https://indigoengine.io/docs/quickstart/setup-and-configuration#for-sbt

### Run

```bash
sbt compile fastOptJS indigoRun
```

Custom sbt commands

`build.sbt`:
```sbt
addCommandAlias("buildGame", ";compile;fastOptJS;indigoBuild")
addCommandAlias("runGame", ";compile;fastOptJS;indigoRun")
addCommandAlias("buildGameFull", ";compile;fullOptJS;indigoBuildFull")
addCommandAlias("runGameFull", ";compile;fullOptJS;indigoRunFull")
```

### 오류
runGame 에서 의존성 오류 발생.

```
sh: electron: command not found
```
electron 설치 => 해결

## 실행 오류
- `IndigoSandbox`를 상속하면 기본적으로 구현해야할 요소들이 있음. 
- 실행화면에서 개발자도구를 열면 오류의 내용을 확인할 수 있음. 

화면에 파란색 네모를 띄우는데 성공함. 

`IndigoSandbox`에 대한 이해가 필요함. 

## Indigo Framework 이해
### Frame context
참고: https://indigoengine.io/docs/gameloop/frame-context

Framecontext 를 고안한 의도. 
> To make these things testable, a deterministic frame context is provided to give you a predictable environment to work in.

이게 무슨말이냐면, 객체의 이전상태 뿐만 아니라, game 시간이나 사용자의 입력 등 context 에 따라서도
객체의 상태가 변화한다는 것을 뜻함. context 도 결정적인 입력으로 만들어서 테스트 가능하게 함. 

> Updating - ...the model and view model based on events and previous state
Presenting - ...the frame to the player

model 과 view model 을 나누고 있다. 
이전 상태와 발생한 이벤트에 따라서 model 과 view model 이 업데이트 된다. 

### hot reload
파일변화시에 컴파일 되도록 함. 
`build.sbt`:
```sbt
addCommandAlias("buildGame", ";~compile;fastOptJS;indigoBuild")
```

컴파일 결과를 반영해서 서버를 재구동. 
parcel.js - https://parceljs.org/getting-started/webapp/

`package.json`:
```json
{
  "scripts": {
    "start": "parcel ./target/indigoBuild/index.html"
  },
  "dependencies": {
    "electron": "^23.1.2"
  },
  "devDependencies": {
    "parcel": "^2.8.3"
  }
}

```

## sbt 이전 커맨드 반복 실행
press `r` key

## 해야할 일
- [ ] Game Scene 만들기
- [ ] Block Entity
  - [ ] 화면에 표시
  - [ ] 낙하 
