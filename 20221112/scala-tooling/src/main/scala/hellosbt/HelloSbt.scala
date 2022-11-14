package hellosbt

@main def run(name: String): Unit =
  val greeting = "Hello, " + name + "!"
  println(fansi.Color.Blue(greeting))
