import org.scalatest.funsuite.AnyFunSuite
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.PriorityQueue

// #. 문제 분석
// 매일 발표된 명예의 전당의 최하위 점수를 반환하면 된다.

// ##. 풀이 설계
// 점수 기준의 내림차순으로 정렬된 K개의 숫자를 얻기 위해서 max heap 구조를 활용해 볼 수 있다.
// 매일 최하위 값을 구하기 위해서는 K번째를 찾기위한 추가 탐색이 필요하다.

// ###. 시간복잡도의 계산
// 주어진 Score의 개수를 n이라 한다면,
// max heap 구조에 삽입하는 연산은 총 n log(n) 이 된다.
// k개의 자료만 유지하면 되므로, 실제로는 n log(k) 로 줄일 수 있다.
//
// min heap으로 처리가 가능하다.

// ##. 풀이 설계 수정
// 핵심은 명예의 전당의 개수를 k개 유지하는 것이다.
// 유지는 가장 작은 것을 제외하는 것이다.
// 즉, 사이즈가 k인 min heap을 이용해서 가장 작은 것을 제외하는 자료구조를 만들 수 있다.

// ##. 도구
// - PriorityQueue https://www.scala-lang.org/api/2.13.x/scala/collection/mutable/PriorityQueue.html

// ##. 풀이
// ###. 가변구조를 활용한 풀이
// ListBuffer를 활용.

// ##. 보완할 점
// - given 객체의 활용. => PrirorityQueue의 Ordering 규칙을 정하는 부분이 context parameter 형식으로 되어 있음.
// - scala 2, 3 문법 차이

class ScoreBoard(capicity: Int) {
  val board = PriorityQueue[Int]()(Ordering.Int.reverse)

  def add(score: Int): Unit = {
    board.addOne(score)
    if (board.size > capicity) {
      board.dequeue
    }
  }

  def min(): Int = board.min
}

object Solution {
  def solution(k: Int, scores: Vector[Int]): Vector[Int] = {
    val kthScores = ListBuffer[Int]()

    val scoreBoard = ScoreBoard(capicity = k)
    scores.foreach((score) => {
      scoreBoard.add(score)
      kthScores.addOne(scoreBoard.min())
    })

    kthScores.toVector
  }
}

class Test extends AnyFunSuite:
  test("simple") {
    assert(
      Solution.solution(3, Vector(10, 100, 20, 150, 1, 100, 200))
        == Vector(10, 10, 10, 20, 20, 100, 100)
    )
    assert(
      Solution.solution(4, Vector(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000))
        == Vector(0, 0, 0, 0, 20, 40, 70, 70, 150, 300)
    )
  }
