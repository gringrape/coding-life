package tetris

package scenes

import indigo.scenes.Scene
import indigo.scenes.SceneEvent
import indigo.scenes.SceneContext
import indigo.scenes.SceneName

import indigo.shared.Outcome
import indigo.shared.utils.Lens
import indigo.shared.constants.Key
import indigo.shared.subsystems.SubSystem

import indigo.shared.events.GlobalEvent
import indigo.shared.events.EventFilters
import indigo.shared.events.KeyboardEvent

import indigo.shared.scenegraph.SceneUpdateFragment
import indigo.shared.scenegraph.Shape

import indigo.shared.datatypes.Rectangle
import indigo.shared.datatypes.Size
import indigo.shared.datatypes.Fill
import indigo.shared.datatypes.RGBA
import indigo.shared.datatypes.Point
import indigo.shared.scenegraph.Group
import indigo.shared.datatypes.Stroke
import indigo.shared.scenegraph.SceneNode

import tetris.models.GameModel
import tetris.models.ViewModel

import tetris.scenes.Cell.unitSize
import tetris.scenes.Cell.unitSize

object GameScene extends Scene[MyStartupData, GameModel, ViewModel] {
  val viewportWidth = TetrisGame.config.viewport.width
  val viewportHeight = TetrisGame.config.viewport.height

  type SceneModel = Unit
  type SceneViewModel = Unit

  override def subSystems: Set[SubSystem] = Set()

  override def updateModel(
      context: SceneContext[MyStartupData],
      model: SceneModel
  ): GlobalEvent => Outcome[SceneModel] =
    case KeyboardEvent.KeyDown(Key.ENTER) =>
      Outcome(model)
        .addGlobalEvents(SceneEvent.JumpTo(SceneName("end")))
    case _ => Outcome(model)

  override def updateViewModel(
      context: SceneContext[MyStartupData],
      model: SceneModel,
      viewModel: SceneViewModel
  ): GlobalEvent => Outcome[SceneViewModel] = (e: GlobalEvent) =>
    Outcome(viewModel)

  override def name: SceneName = SceneName("game")

  override def eventFilters: EventFilters = EventFilters.Restricted

  val modelLens: Lens[GameModel, Unit] = Lens.unit

  val viewModelLens: Lens[ViewModel, SceneViewModel] = Lens.unit

  override def present(
      context: SceneContext[MyStartupData],
      model: Unit,
      viewModel: Unit
  ): Outcome[SceneUpdateFragment] =
    Outcome(
      SceneUpdateFragment.empty
        .addLayer(
          Block(blockType = BlockType.L, leftTopPosition = Grid(1, 1)),
          Block(blockType = BlockType.I, leftTopPosition = Grid(8, 1))
        )
    )
}

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
