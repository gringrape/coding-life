import org.scalatest.funsuite.AnyFunSuite

// 무엇을 할건가?
// - Ordering 객체를 given definition 을 이용해서 구현한다. 
// - 없애면 omit context paramter on calling 이 나온다. => 컴파일러가 타입에 맞는 객체를 발견하지 못한것. 

trait Ordering[A]:
  def lt(a: A, b: A): Boolean

object Ordering:
  given Int: Ordering[Int] with
    def lt(a: Int, b: Int): Boolean = a < b
  given String: Ordering[String] with
    def lt(a: String, b: String): Boolean = a.length() < b.length()
  given Double: Ordering[Double] with
    def lt(a: Double, b: Double): Boolean = a < b

class Test extends AnyFunSuite:
  def lessThan[A](a: A, b: A)(using ordering: Ordering[A]): Boolean =
    ordering.lt(a, b)

  test("Omit context parameter on calling") {
    assert(lessThan(1, 2) == true)
    assert(lessThan("999", "1111") == true)
    assert(lessThan(1.1, 2.0) == true)
  }
