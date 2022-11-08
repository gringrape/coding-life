import org.scalatest.funspec.AnyFunSpec

val g = 9.81

case class Position(x: Double, y: Double):
  val coordinates = (x, y)

  def distanceToPosition(position: Position) =
    val deltaX = math.abs(x - position.x)
    val deltaY = math.abs(y - position.y)
    math.sqrt(math.pow(deltaX, 2) + math.pow(deltaY, 2))

  def distanceToLine(line: (Position, Position)) =
    val (position1, position2) = line
    val (x1, y1, x2, y2) = position1.coordinates ++ position2.coordinates

    val triangleArea = math.abs((y1 - y) * (x2 - x1) - (x1 - x) * (y2 - y1)) / 2

    2 * triangleArea / position1.distanceToPosition(position2)

object Position:
  val player = Position(0, 1.80)
  val hoop = Position(6.75, 3.048)

case class Angle(degrees: Double):
  val toRadian = degrees * math.Pi / 180
case class Speed(metersPerSecond: Double):
  val amount = metersPerSecond
case class Velocity(angle: Angle, speed: Speed):
  val x = math.cos(angle.toRadian) * speed.amount
  val y = math.sin(angle.toRadian) * speed.amount

def position(timing: Double, velocity: Velocity): Position =
  val x = velocity.x * timing + Position.player.x
  val y =
    velocity.y * timing - 0.5 * g * (math.pow(timing, 2)) + Position.player.y
  Position(x, y)

def isNotTooFar(position: Position): Boolean = position.y >= 0

def goesThroughHoop(line: (Position, Position)): Boolean =
  Position.hoop.distanceToLine(line) <= 0.01

def isWinningShot(angle: Angle, speed: Speed) =
  val timings = LazyList.from(0).map(_ * .1)
  val positions =
    timings
      .map((timing) => position(timing, Velocity(angle, speed)))
      .takeWhile(isNotTooFar)
  val lines = positions.zip(positions.drop(1))
  print(lines.map(Position.hoop.distanceToLine).toList.min)

  lines
    .exists(goesThroughHoop)

class BasketBallTest extends AnyFunSpec {
  describe("isWinningShot") {
    it("should return whether the shor is succeful or not") {
      assert(
        isWinningShot(
          angle = Angle(degrees = 48),
          speed = Speed(metersPerSecond = 7.05)
        ) == true
      )
    }
  }

  describe("position") {
    it("returns x position moving with constant speed") {
      val initialHorizontalPosition = Position.player.x

      val movedPosition = position(2, Velocity(Angle(0), Speed(5)))

      assert(movedPosition.x == initialHorizontalPosition + 10)
    }

    it("returns y position moving with gravity accelarated") {
      val initialVerticalPosition = Position.player.y

      val movedPosition = position(2, Velocity(Angle(90), Speed(2 * g)))

      assert(movedPosition.y == 2 * g + initialVerticalPosition)
    }
  }
}
