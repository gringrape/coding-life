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
import indigo.shared.time.Seconds

import indigo.shared.events.GlobalEvent
import indigo.shared.events.EventFilters
import indigo.shared.events.KeyboardEvent
import indigo.shared.events.FrameTick

import indigo.shared.scenegraph.SceneUpdateFragment
import indigo.shared.scenegraph.Shape
import indigo.shared.scenegraph.Group
import indigo.shared.scenegraph.SceneNode

import indigo.shared.datatypes.Rectangle
import indigo.shared.datatypes.Size
import indigo.shared.datatypes.Fill
import indigo.shared.datatypes.RGBA
import indigo.shared.datatypes.Point
import indigo.shared.datatypes.Stroke

import tetris.scenes.GameScene.viewportWidth
import tetris.scenes.GameScene.viewportHeight

import tetris.models.GameModel
import tetris.models.ViewModel
import tetris.models.BlockModel

import tetris.viewModels.Block
import tetris.viewModels.BlockType
import tetris.viewModels.Cell
import tetris.viewModels.Grid
import tetris.viewModels.Board
import scala.scalajs.js.Date
import org.scalajs.dom.WindowConsole

object GameScene extends Scene[MyStartupData, GameModel, ViewModel] {

  val viewportWidth = TetrisGame.config.viewport.width
  val viewportHeight = TetrisGame.config.viewport.height

  type SceneModel = GameModel
  type SceneViewModel = Unit

  override def subSystems: Set[SubSystem] = Set()

  override def updateModel(
      context: SceneContext[MyStartupData],
      model: SceneModel
  ): GlobalEvent => Outcome[SceneModel] =
    case KeyboardEvent.KeyDown(Key.ENTER) =>
      Outcome(model)
        .addGlobalEvents(SceneEvent.JumpTo(SceneName("end")))
    case FrameTick =>
      Outcome(
        model.update(
          model.block.moveDown(duration = context.delta)
        )
      )
    case _ => Outcome(model)

  override def updateViewModel(
      context: SceneContext[MyStartupData],
      model: SceneModel,
      viewModel: SceneViewModel
  ): GlobalEvent => Outcome[SceneViewModel] = (e: GlobalEvent) =>
    Outcome(viewModel)

  override def name: SceneName = SceneName("game")

  override def eventFilters: EventFilters = EventFilters.Restricted

  val viewModelLens: Lens[ViewModel, SceneViewModel] = Lens.unit

  override def modelLens: Lens[GameModel, GameModel] = Lens.keepLatest

  override def present(
      context: SceneContext[MyStartupData],
      model: GameModel,
      viewModel: Unit
  ): Outcome[SceneUpdateFragment] =
    val block = model.block
    Outcome(
      SceneUpdateFragment.empty
        .addLayer(
          Board()
        )
        .addLayer(
          Block(
            blockType = BlockType.L,
            leftTopPosition = Grid(block.cellX, block.cellY)
          ),
          Block(blockType = BlockType.I, leftTopPosition = Grid(8, 1))
        )
    )
}
