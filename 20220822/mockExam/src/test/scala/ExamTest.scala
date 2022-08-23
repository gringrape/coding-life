import org.scalatest.funspec.AnyFunSpec

import exam.Student

class ExamTest extends AnyFunSpec {
  describe("countCorrectAnswers") {
    it("returns correct answer count") {
      val student = Student(id = 1, answerPattern = (1, 2, 3, 4, 5))

      val exam = new Exam(solutions = List(1, 2, 3, 4, 5, 1))

      assert(
        exam.countCorrectAnswers(student) == 6
      )
    }
  }
}
