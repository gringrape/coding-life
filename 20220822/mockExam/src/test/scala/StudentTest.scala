import org.scalatest.funspec.AnyFunSpec

import exam.Student

class StudentTest extends AnyFunSpec {
  val context = describe _

  describe("answer") {
    context("when problem number less than or equal to pattern size") {
      it("returns answer with exact position in the pattern") {
        val student = Student(id = 1, answerPattern = (1, 2, 3, 4, 5))

        assert(student.answer(problemNumber = 1) === 1)
        assert(student.answer(problemNumber = 5) === 5)
      }
    }
    context("when problem number greater than pattern size") {
      it("returns answer using cycle") {
        val student = Student(id = 1, answerPattern = (1, 2, 3, 4, 5))

        assert(student.answer(problemNumber = 101) === 1)
        assert(student.answer(problemNumber = 205) === 5)
      }
    }
  }
}
