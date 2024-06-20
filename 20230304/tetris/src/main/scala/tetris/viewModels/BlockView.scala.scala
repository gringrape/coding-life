package tetris

package viewModels

import indigo.shared.datatypes.RGBA
import indigo.shared.datatypes.Rectangle
import indigo.shared.datatypes.Point
import indigo.shared.datatypes.Size
import indigo.shared.datatypes.Fill
import indigo.shared.datatypes.Stroke

import indigo.shared.scenegraph.Group
import indigo.shared.scenegraph.SceneNode
import indigo.shared.scenegraph.Shape

enum BlockType(val shape: List[(Int, Int)], val color: RGBA):
  case L
      extends BlockType(
        shape = List((0, 0), (0, 1), (0, 2), (1, 2)),
        color = RGBA.Green
      )
  case I
      extends BlockType(
        shape = List((0, 0), (0, 1), (0, 2), (0, 3)),
        color = RGBA.Red
      )

case class Block(blockType: BlockType, leftTopPosition: Grid)

object Block:
  def apply(blockType: BlockType, leftTopPosition: Grid) =
    val x = leftTopPosition.x
    val y = leftTopPosition.y

    Group(
      blockType.shape.map(cooridinates =>
        val (a, b) = cooridinates
        Cell(position = Grid(x + a, y + b), color = blockType.color)
      ): _*
    )

case class Grid(x: Int, y: Int)

case class Cell(position: Grid, color: RGBA)

object Cell:
  val unitSize = 20

  def apply(position: Grid, color: RGBA): SceneNode =
    Shape.Box(
      dimensions = Rectangle(
        position = Point(position.x * unitSize, position.y * unitSize),
        size = Size(unitSize)
      ),
      fill = Fill.Color(color),
      stroke = Stroke(1).withColor(RGBA.SlateGray)
    )
