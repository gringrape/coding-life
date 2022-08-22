package exam

case class Student(
    val pattern: Tuple5[Int, Int, Int, Int, Int]
) {
  def answer(problemNumber: Int) = {
    val index = problemNumber match {
      case x if x > 5 => problemNumber % 5 - 1
      case _          => problemNumber - 1
    }

    pattern.productElement(index)
  }
}
