// "원"과 "직사각형"을 포함하는 "모양"을 만들어보자. 
sealed trait Shape:
  val area = this match
    case Rectangle(width, height) => width * height 
    case Circle(radius) => radius * radius * math.Pi

case class Rectangle(width: Int, height: Int) extends Shape
case class Circle(radius: Int) extends Shape

val shape: Shape = Rectangle(width=3, height=5)
val anotherShape: Shape = Circle(radius=3)

shape.area
anotherShape.area
