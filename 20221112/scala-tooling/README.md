# 스칼라 프로젝트 시작하기

## 프로그램 메타정보
`build.sbt`에 언어의 버전과 의존성등의 정보를 작성해 줄 수 있다.
언어를 지정해주자. 

`build.sbt`:
```sbt
sbt.version=1.7.1
```

`import build`를 실행하면, `project` 폴더가 생성되는 것을 확인할 수 있다.

## 빌드 속성
`/project/build.properties`:
```properties
sbt.version=1.7.3
```

## 라이브러리 추가
`Scaladex`를 이용해서 추가할 라이브러리를 검색할 수 있다.
Scaladex: https://index.scala-lang.org/

`fansi`라이브러리를 추가해주자. 

`build.sbt`:
```sbt
scalaVersion := "3.2.0"
libraryDependencies += "com.lihaoyi" %% "fansi" % "0.4.0"
```

### 프로그램 소스 코드
`/src/main/scala` 경로에 scala 파일을 추가해주자.
Hello, World 를 출력하기 위한 소스코드를 작성하자. 

`/src/main/scala/hellosbt/HelloSbt.scala`:
```scala
package hellosbt

@main def run(): Unit =
  val greeting = "Hello, World!"
  println(greeting)

```

```bash
sbt run
```

![](https://user-images.githubusercontent.com/53764714/201454433-18ab64d7-b0fc-4ca4-942c-06cf8e5a0aab.png)

`fansi`를 이용해서 글자에 색깔을 입혀보자. 

`/src/main/scala/hellosbt/HelloSbt.scala`:
```scala
package hellosbt

@main def run(): Unit =
  val greeting = "Hello, World!"
  println(fansi.Color.Blue(greeting))
```

## 테스팅 라이브러리 추가
MUnit: https://scalameta.org/munit/

`build.sbt`:
```sbt
// ...
libraryDependencies ++= List(
  // ...
  "org.scalameta" %% "munit" % "0.7.29" % Test
)
```

`src/test/scala/hellosbt/HelloSbt.scala`:
```scala
package hellosbt

import munit.FunSuite

class HelloSbtSuite extends FunSuite:
  test("testing impossible") {
    assert(1 + 1 == 2)
  }

```

```bash
sbt test
```

![](https://user-images.githubusercontent.com/53764714/201454811-b5485af1-0dc1-4191-af76-a639ba3107ba.png)
