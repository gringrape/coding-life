import org.scalatest.funsuite.AnyFunSuite

import exam.Student

class CubeCalculatorTest extends AnyFunSuite {
  test("answer") {
    val student = Student(pattern = (1, 2, 3, 4, 5))

    assert(student.answer(problemNumber = 1) === 1)
    assert(student.answer(problemNumber = 2) === 2)

    assert(student.answer(problemNumber = 6) === 1)
  }
}
