package tetris

package scenes

import indigo.scenes.Scene
import indigo.scenes.SceneName
import indigo.scenes.SceneContext
import indigo.scenes.SceneEvent

import indigo.shared.events.GlobalEvent
import indigo.shared.utils.Lens
import indigo.shared.Outcome
import indigo.shared.scenegraph.SceneUpdateFragment
import indigo.shared.events.EventFilters
import indigo.shared.subsystems.SubSystem
import indigo.shared.scenegraph.Group
import indigo.shared.scenegraph.Shape
import indigo.shared.datatypes.Fill
import indigo.shared.datatypes.Stroke
import indigo.shared.scenegraph.TextBox
import indigo.shared.datatypes.RGBA
import indigo.shared.datatypes.Point
import indigo.shared.datatypes.TextStroke
import indigo.shared.datatypes.Pixels
import indigo.shared.time.Seconds
import indigo.shared.events.MouseEvent.Click
import indigo.shared.events.MouseEvent

import tetris.models.GameModel
import tetris.models.ViewModel

import tetris.MyStartupData
import indigo.shared.events.KeyboardEvent
import org.scalajs.dom.KeyCode
import indigo.shared.constants.Key

object StartScene extends Scene[MyStartupData, GameModel, ViewModel] {
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
        .addGlobalEvents(SceneEvent.JumpTo(SceneName("game")))
    case _ => Outcome(model)

  override def updateViewModel(
      context: SceneContext[MyStartupData],
      model: SceneModel,
      viewModel: SceneViewModel
  ): GlobalEvent => Outcome[SceneViewModel] = (e: GlobalEvent) =>
    Outcome(viewModel)

  override def name: SceneName = SceneName("start")

  override def eventFilters: EventFilters = EventFilters.Restricted

  val modelLens: Lens[GameModel, Unit] = Lens.unit

  val viewModelLens: Lens[ViewModel, SceneViewModel] = Lens.unit

  def drawTitle(): TextBox =
    val fontSize = 50;
    val (textWidth, textHeight) = (fontSize * 5, fontSize);

    TextBox("테트리스", textWidth, textHeight)
      .withColor(RGBA.Black)
      .withFontSize(Pixels(fontSize))
      .withPosition(
        Point(viewportWidth / 2 - textWidth / 2, fontSize / 2)
      )
      .withStroke(TextStroke(RGBA.Black, Pixels(2)))
      .alignCenter

  def drawStartButton() =
    val fontSize = 30;
    val (textWidth, textHeight) = (fontSize * 5, fontSize * 2);

    val textBox = TextBox("시작하기", textWidth, textHeight)
      .withColor(RGBA.Black)
      .withFontSize(Pixels(fontSize))
      .withPosition(
        Point(
          viewportWidth / 2 - textWidth / 2,
          viewportHeight - textHeight * 2
        )
      )
      .alignCenter

    Group(
      Shape.Box(
        textBox.bounds.moveBy(Point(0, -(textHeight - fontSize) / 2)),
        Fill.None,
        Stroke(4)
      ),
      textBox
    )

  override def present(
      context: SceneContext[MyStartupData],
      model: Unit,
      viewModel: Unit
  ): Outcome[SceneUpdateFragment] =
    Outcome(
      SceneUpdateFragment.empty
        .addLayer(
          drawTitle(),
          drawStartButton()
        )
    )
}
