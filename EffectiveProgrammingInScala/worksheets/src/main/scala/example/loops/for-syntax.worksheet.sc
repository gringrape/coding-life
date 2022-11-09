// for syntax 연습
// 1. 배열에서 짝수 골라내기

val numbers = 1 to 6
val evenNumbers = 
  for number <- numbers if number % 2 == 0 yield number
   
evenNumbers // 2, 4, 6, 8 ...
evenNumbers.sum

// 2. 결과를 변형하기

val oddNumbersSquared =
  for number <- numbers if number % 2 == 1 yield number * number
oddNumbersSquared

// 3. 여러개의 Generator

val names = List("Hanna", "Jane", "Jin")

val numberAndNames =
  for 
    number <- numbers 
    name <- names 
  yield (number, name)
numberAndNames

// 4. permutation

val combinations =
  for 
    number1 <- numbers
    number2 <- numbers 
    if number1 < number2
  yield (number1, number2)
