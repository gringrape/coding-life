// Constructing a list
val emptyList = List.empty[Int]

val numbers: List[Int] = List(1, 2, 3)

// Pattern matching
val firstNumber = numbers match
  case h :: t => h
  case Nil => -100

// Appending an element
numbers :+ 4

// Prepending an element 
0 +: numbers

// Tuples
val pair = (1, 3)
val name = ("name" -> "Minho")

// Tuple destrcuturing
val (first, second) = (10, 15) 

// Map
val minho = Map.empty[String, String]

minho + ("name" -> "Minho") + ("age" -> "17")


