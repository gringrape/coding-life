import exam.Student

class Exam(
    val solutions: List[Int]
) {
  def solutionOf(problemNumber: Int) = {
    solutions(problemNumber - 1)
  }

  def countCorrectAnswers(student: Student) = {
    val problemNumbers = (1 to solutions.size)

    problemNumbers.count(number => {
      solutionOf(problemNumber = number) == student.answer(problemNumber =
        number
      )
    })
  }
}
