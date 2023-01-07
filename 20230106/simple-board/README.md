# 게시판

간단한 Kotlin Spring 연습.

## 프로젝트 시작
Spring Initializer 활용. (start.spring.io)
### dependencies
- spring boot starter web
- spring boot devtools
- h2 database

## 할 일
전체적인 할 일은 게시글의 목록, 상세, 입력, 수정, 삭제
영속성까지 쭉 실험해보기.

- [x] kotest 환경설정
- [x] 계산기 덧셈 메서드를 통해서 kotest의 동작과 스펙 작성법 확인
- [x] greeting -> "/" 경로에서 "hello"를 반환한다. 
- [ ] 글 목록 -> "/posts" 경로에서 글 목록을 반환한다. 

### 게시글 설정
- 구성: 작성자, 제목, 글 내용, 작성 시간
- 예시

{
  "author": "Jin",
  "title": "피곤한 하루",
  "content": "아무것도 하기 싫다",
  "date": "2023-01-06T09:35:23.493Z"
}

## Kotest 설정
설정 - https://kotest.io/docs/quickstart
Spring DI를 이용하기 위한 설정 - https://kotest.io/docs/extensions/spring.html

## Kotest
DescribeSpec - https://kotest.io/docs/framework/testing-styles.html#describe-spec
Setup mocks - https://kotest.io/docs/framework/integrations/mocking.html#option-1---setup-mocks-before-tests

## Exposed Spring Starter
Hibernate를 대신해서 Exposed를 ORM 도구로 사용할 수 있게 해줌. 
https://github.com/JetBrains/Exposed/blob/c6cf3792997b28a2c6617c17adc5460ed77a1da7/exposed-spring-boot-starter/README.md

### DSL 
https://github.com/JetBrains/Exposed/wiki/DSL

## 알게 된것
- live reload server - https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html#using-boot-devtools-livereload
- kotest library import 시 버전 명시를 해주지 않아서 못 불러옴.
- 특정 port 번호에 있는 프로세스 삭제 https://stackoverflow.com/questions/3855127/find-and-kill-process-locking-port-3000-on-mac
- Spring Boot 3.0.0 에서 데이터 베이스 연결이 안되는 이슈 https://github.com/JetBrains/Exposed/issues/1636
- insert 쿼리문 틀림.

```sql
INSERT INTO
Posts (ID, AUTHOR, TITLE, CONTENT, CREATED)
VALUES ('1', 'Jin', 'Hello', 'My name is Park', '2022-02-03T03:24:48')  
```

- 도메인 객체를 초기화할때 id에 파라메터를 받지 않고 초기화.
```kotlin
class Post(
    id: Long? = null,
    val author: String,
    val title: String,
    val content: String,
    val created: LocalDateTime,
) {
    var id: Long = INITIAL_ID
      private set
  
    init {
      if (id != null) {
        this.id = id
      }
    }
}
```

## 생각들
- DTO 의 Date 형식의 타입은 DateTime, String 이어야 할까?
