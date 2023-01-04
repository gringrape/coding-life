trait Comparable:
  def lessThan(other: Comparable): Boolean

case class Rational(numer: Int, denom: Int) extends Comparable:
  def lessThan(other: Comparable): Boolean =
    val otherNumber = other.asInstanceOf[Rational]
    this.numer * otherNumber.denom < otherNumber.numer * this.denom

def sort(list: List[Comparable]): List[Comparable] =
  list.sortWith((a, b) => a.lessThan(b))

sort(List(Rational(3, 4), Rational(2, 3)))
