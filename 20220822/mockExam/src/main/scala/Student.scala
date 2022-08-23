package exam

case class Student(
    val id: Number,
    val answerPattern: Tuple5[Int, Int, Int, Int, Int]
) {
  def answer(problemNumber: Int) = {
    val index = problemNumber match {
      case x if x > 5 => (problemNumber - 1) % 5
      case _          => problemNumber - 1
    }

    answerPattern.productElement(index)
  }
}
