import munit.FunSuite
import munit.ScalaCheckSuite
import org.scalacheck.Prop.forAll
import org.scalacheck.Gen

def fibonacci(n: Int): Int =
  def fibonacciIterative(k: Int, a: Int, b: Int): Int =
    if k == 0 then a
    else fibonacciIterative(k - 1, b, a + b)
  fibonacciIterative(n, 0, 1)

class FibonacciTest extends FunSuite:
  test("sample") {
    assertEquals(fibonacci(0), 0)
    assertEquals(fibonacci(1), 1)
    assertEquals(fibonacci(10), 55)
  }

class FibonacciPropertiesTest extends ScalaCheckSuite:
  val fibonacciDomain = Gen.choose(2, 10000)

  property("A fibonacci number should be the sum of two previous numbers") {
    forAll(fibonacciDomain) { (n: Int) =>
      fibonacci(n) == fibonacci(n - 1) + fibonacci(n - 2)
    }
  }
