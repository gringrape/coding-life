import scala.collection.mutable.ArrayBuffer

// concatenation
List(1, 2, 3) ++ List(4, 5)

// mutable operations
val numbers = ArrayBuffer(1, 2, 3)

numbers += 4
numbers --= List(1, 2)
numbers -= 3

numbers // all operations above have mutated numbers

// 배운 것.
// - scala import 
