package tetris.viewModels

import indigo.shared.scenegraph.Shape
import indigo.shared.scenegraph.Group
import indigo.shared.scenegraph.SceneNode

import indigo.shared.datatypes.Rectangle
import indigo.shared.datatypes.Point
import indigo.shared.datatypes.Size
import indigo.shared.datatypes.Fill
import indigo.shared.datatypes.RGBA

import tetris.scenes.EndScene.viewportWidth
import tetris.scenes.EndScene.viewportHeight

final case class Board()

object Board:
  val Background =
    Shape.Box(
      dimensions = Rectangle(
        position = Point(0, 0),
        size =
          Size(width = viewportWidth, height = viewportHeight - Cell.unitSize)
      ),
      fill = Fill.Color(RGBA.Black)
    )

  val lastX = viewportWidth / Cell.unitSize - 1
  val lastY = viewportHeight / Cell.unitSize - 1

  val Border =
    Group(
      Range(0, lastX + 1)
        .flatMap(x => Range(0, lastY + 1).map(y => (x, y)))
        .filter((x, y) => x == 0 || x == lastX || y == 0 || y == lastY)
        .map((x, y) => Cell(Grid(x, y), RGBA.Silver)): _*
    )

  def apply(): SceneNode =
    Group(
      Background,
      Border
    )
