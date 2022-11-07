import scala.math.abs
import scala.math.sqrt
import scala.math.pow
import scala.math.Pi

case class Position(x: Double, y: Double):
  val coordinates = (x, y)

  def distanceTo(that: Position): Double =
    val dx = this.x - that.x
    val dy = this.y - that.y
    math.sqrt(dx * dx + dy * dy)
  def distanceToLine(line: (Position, Position)): Double =
    val (p1, p2) = line
    val (x1, y1, x2, y2) = p1.coordinates ++ p2.coordinates

    val deltaX = x2 - x1
    val deltaY = y2 - y1
    val lineLength = sqrt(pow(deltaX, 2) + pow(deltaY, 2))
    
    val triangleArea = abs(deltaX * (y1 - y) - deltaY * (x1 - x)) / 2

    val height = 2 * triangleArea / lineLength
    height

Position(0, 0).distanceToLine((Position(1, 0), Position(0, 1)))


object Position:
  val player = Position(0, 1.80)
  val hoop   = Position(6.75, 3.048)

case class Angle(degrees: Double):
  val radians = degrees * Pi / 180
case class Speed(metersPerSecond: Double)

def isWinningShot(angle: Angle, speed: Speed): Boolean =
  val v0X = speed.metersPerSecond * math.cos(angle.radians)
  val v0Y = speed.metersPerSecond * math.sin(angle.radians)
  val p0X = Position.player.x
  val p0Y = Position.player.y
  val g   = -9.81
  def goesThroughHoop(line: (Position, Position)): Boolean =
    Position.hoop.distanceToLine(line) < 0.01
  def isNotTooFar(position: Position): Boolean =
    position.y > 0 && position.x <= Position.hoop.x + 0.01
  def position(t: Int): Position =
    val x = p0X + v0X * t
    val y = p0Y + v0Y * t + 0.5 * g * t * t
    Position(x, y)

  def loop(time: Int): Boolean =
    val currentPosition = position(time)
    if isNotTooFar(currentPosition) then
      val nextPosition = position(time + 1)
      val line = (currentPosition, nextPosition)
      goesThroughHoop(line) || loop(time + 1)
    else
      false

  loop(time = 0)
end isWinningShot

val angle = Angle(48)
val speed = Speed(7.92)

isWinningShot(angle, speed)
