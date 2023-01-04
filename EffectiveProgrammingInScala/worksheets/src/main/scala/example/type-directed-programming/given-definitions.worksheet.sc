// 목표
// 여러개의 given definition이 주어질때 우선순위가 높은 것을 택하는 것을 실험.
// - 우선 순위의 판단기준에 따라 다른예제 적용.

// 1. 상속관계에서 보다 가까운 쪽.
trait A:
  given int1: Int = 1
  given string: String = "HaHa"

trait B extends A:
  given int2: Int = 2

object C extends B:
  val value = summon[Int]
  val text = summon[String]

C.value
C.string

// 2. 보다 가까운 lexical scope

given int1: Int = 1
def value =
  given int2: Int = 2
  summon[Int]

value

// 3. 구체적인 타입

class General:
  val value = 1
class Specific extends General:
  override val value = 2

given general: General = General()
given specific: Specific = Specific()

summon[General].value
