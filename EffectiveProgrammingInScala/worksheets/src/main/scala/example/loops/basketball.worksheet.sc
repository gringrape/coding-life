// Units
// - 길이: meter
// - 시간: second

case class Position(x: Double, y: Double):
  def distanceToLine(line: (Position, Position)) = 1

object Position:
  val player = Position(0, 1.8)
  val hoop = Position(5.8, 3.1)

case class Speed(speed: Double, angle: Double):
  val degreeAngle = angle * math.Pi / 180
  val x = speed * math.cos(degreeAngle)
  val y = speed * math.sin(degreeAngle)

def isWinningShot(angle: Int, speed: Int) =
  val initialVelocity = Speed(speed, angle)

  def position(time: Int) =
    val g = 9.8
    val velocityY = initialVelocity.y - g * time
    val x = Position.player.x + time * initialVelocity.x
    val y = (initialVelocity.y + velocityY) / 2 * time
    Position(x, y)
    
  def isNotTooFar(position: Position) =
    position.y >= 0 && (position.x < Position.hoop.x + 0.01)

  def goesThroughHoop(line: (Position, Position)) =
    Position.hoop.distanceToLine(line) < 0.05
 
  val timings = LazyList.from(0)
  val positions = timings.map(position)
  val lines = positions.zip(positions.tail)
  lines
    .takeWhile((p1, _) => isNotTooFar(p1))
    .exists(goesThroughHoop)

isWinningShot(angle=30, speed=5)
