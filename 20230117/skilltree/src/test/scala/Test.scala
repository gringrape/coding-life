import org.scalatest.funsuite.AnyFunSuite

class Test extends AnyFunSuite:
  def countValidSkillTrees(skillOrder: String, skillTrees: List[String]):Int =
    val skillsInSkillOrder = (skillTree: String) => skillTree.filter(skillOrder.contains(_)) 
    val isRightOrder = (skills) => skillOrder.startsWith(skills) 

    skillTrees.map(skillsInSkillOrder)
      .count(isRightOrder)  

  test("sample") {
    val skillOrder = "CBD"
    val skillTrees = List("BACDE", "CBADF", "AECB", "BDA")

    assert(countValidSkillTrees(skillOrder, skillTrees) == 2)
  }
