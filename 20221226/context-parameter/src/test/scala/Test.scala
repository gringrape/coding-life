import org.scalatest.funsuite.AnyFunSuite

class Test extends AnyFunSuite:
  def lessThan[A](a: A, b: A)(using ordering: Ordering[A]): Boolean =
    ordering.lt(a, b)

  test("Omit context parameter on calling") {
    assert(lessThan(1, 2) == true)
    assert(lessThan(3, 2) == false)
  }
