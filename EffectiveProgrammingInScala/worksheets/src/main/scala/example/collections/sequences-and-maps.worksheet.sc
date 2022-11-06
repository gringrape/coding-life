/** Sequence */
// 1. Accessing Sequence element using head and tail decomposition
val numbers = Seq(1, 2, 3)
numbers.head
numbers.tail

// 2. sortBy
val numbersDescendingOrder = numbers.sortBy(number => -number);
numbersDescendingOrder

val nameAndPhoneNumbers = List(
  ("Jin" -> 1234),
  ("Yun" -> 4567),
  ("Whang" -> 8910)
)
nameAndPhoneNumbers.sortBy((name, _) => name)

/** Map */
val phoneNumbersByNames = Map(
  ("Jin" -> 1234),
  ("Yun" -> 4567),
  ("Whang" -> 8910)
)

val names = List(
  "Jin", "Hyun", "Yun"
)
val numberOrEmpty: String => String = name => phoneNumbersByNames.get(name) match 
  case Some(number) => number.toString
  case None => "None" 
names.map(numberOrEmpty)

// 배운 것
// 1. Seq 생성자를 통해서 생성되는 것은 List
