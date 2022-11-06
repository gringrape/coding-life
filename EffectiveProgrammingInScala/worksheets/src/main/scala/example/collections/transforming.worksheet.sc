// 1. foldLeft 연습

// 1 .. 10 까지의 합 계산
val numbers = (1 until 10).toList

val sum = numbers.foldLeft(0) { (acc, number) =>
  acc + number
}
sum

// toList 연산을 foldLeft로 만들기
// prepending이 아닌 appending 연산을 해야 순서가 뒤집히지 않음에 유의하자. 
val numberList = (1 until 10).foldLeft(List.empty[Int]) { (acc, number) => 
  acc :+ number
}
numberList

// 2. groupBy 연습

// 이메일을 도메인에 따라 분류하기.
val domain: String => String = email => email.dropWhile(_ != '@').drop(1)
domain("hello@hi.com")

val emails = List("jin@gmail.com", "jin@naver.com", "gringrape@gmail.com")
emails.groupBy(domain)
