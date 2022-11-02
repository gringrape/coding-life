case class Card(number: Number, shape: Shape, shading: Shading, color: Color)

enum Number:
  case One, Two, Three

enum Shape:
  case Diamond, Squiggle, Oval

enum Shading:
  case Solid, Striped, Open

enum Color:
  case Red, Green, Purple

def isSet(card1: Card, card2: Card, card3: Card) =
  checkColor(card1, card2, card3)
  && checkShape(card1, card2, card3)
  && checkShading(card1, card2, card3)
  && checkNumber(card1, card2, card3)
  
def checkColor(card1: Card, card2: Card, card3: Card): Boolean =
  val allSame = card1.color == card2.color && card2.color == card3.color
  val allDifferent = card1.color != card2.color && card2.color != card3.color && card1.color != card3.color
  allSame || allDifferent

def checkShape(card1: Card, card2: Card, card3: Card): Boolean =
  val allSame = card1.shape == card2.shape && card2.shape == card3.shape
  val allDifferent = card1.shape != card2.shape && card2.shape != card3.shape && card1.shape != card3.shape
  allSame || allDifferent

def checkShading(card1: Card, card2: Card, card3: Card): Boolean =
  val allSame = card1.shading == card2.shading && card2.shading == card3.shading
  val allDifferent = card1.shading != card2.shading && card2.shading != card3.shading && card1.shading != card3.shading
  allSame || allDifferent

def checkNumber(card1: Card, card2: Card, card3: Card): Boolean =
  val allSame = card1.number == card2.number && card2.number == card3.number
  val allDifferent = card1.number != card2.number && card2.number != card3.number && card1.number != card3.number
  allSame || allDifferent

val cards = List(
)

isSet(
    Card(
    number = Number.One, 
    shape = Shape.Diamond,
    shading = Shading.Striped,
    color = Color.Purple
  ),
  Card(
    number = Number.Two, 
    shape = Shape.Squiggle,
    shading = Shading.Open,
    color = Color.Red
  ),
  Card(
    number = Number.Three, 
    shape = Shape.Oval,
    shading = Shading.Solid,
    color = Color.Green
  )
) 