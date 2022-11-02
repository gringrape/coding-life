// 맹인에게 문제가 있을수 있는 색깔
sealed trait PrimaryColor
object PrimaryColor:
  case object Red extends PrimaryColor
  case object Green extends PrimaryColor
  case object Blue extends PrimaryColor

def isProblematicForBlindPeople(color: PrimaryColor) =
  color match 
    case PrimaryColor.Red => true
    case PrimaryColor.Green => false
    case PrimaryColor.Blue => true

isProblematicForBlindPeople(PrimaryColor.Red)
