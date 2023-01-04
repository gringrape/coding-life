// 할 일
// type-class 와 subtyping 을 이용해서 rational number 정렬하기

// 1. Int 정렬
trait Ordering[A]:
  def lt(a: A, b: A): Boolean

object Ordering:
  given Int: Ordering[Int] with
    def lt(a: Int, b: Int) = a <= b
  given Rational: Ordering[Rational] with
    def lt(a: Rational, b: Rational) =
      (a.numer * b.denom) < (b.numer * a.denom)

def sort[A](list: List[A])(using ord: Ordering[A]): List[A] =
  list.sortWith(ord.lt)

sort(List(2, 3, 1))

// 2. rational number 정렬
case class Rational(numer: Int, denom: Int)

sort(List(Rational(3, 4), Rational(2, 3)))
