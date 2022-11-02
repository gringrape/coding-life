// 직사각형의 넓이를 구해보자
case class Rectangle(width: Int, height: Int):
  val area = width * height

val facade = Rectangle(width = 5, height = 3)

facade.area

// 정사각형의 넓이도 구해보자
case class Square(side: Int):
  val area = side * side

val wallet = Square(side = 4)

wallet.area

// 원의 넓이
case class Circle(radius: Int):
  val area = math.Pi * radius * radius

val dish = Circle(radius = 3)

dish.area
