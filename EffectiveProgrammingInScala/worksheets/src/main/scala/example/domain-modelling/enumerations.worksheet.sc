// 맹인에게 문제가 있을수 있는 색깔
enum PrimaryColor:
  case Red, Green, Blue

def isProblematicForBlindPeople(color: PrimaryColor) =
  color match
    case PrimaryColor.Red => true
    case PrimaryColor.Green => false
    case PrimaryColor.Blue => true

isProblematicForBlindPeople(PrimaryColor.Red)
