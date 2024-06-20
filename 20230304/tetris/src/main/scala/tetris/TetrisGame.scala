package tetris

import scala.scalajs.js.annotation.JSExportTopLevel

import indigo.IndigoSandbox
import indigo.Dice
import indigo.Animation
import indigo.GameConfig
import indigo.Shader
import indigo.AssetType
import indigo.FontInfo
import indigo.SceneUpdateFragment
import indigo.FontKey
import indigo.IndigoGame
import indigo.EventFilters
import indigo.BootResult

import indigo.platform.assets.AssetCollection

import indigo.shared.config.GameViewport
import indigo.shared.Startup
import indigo.shared.FrameContext
import indigo.shared.events.GlobalEvent
import indigo.shared.Outcome
import indigo.shared.datatypes.Point
import indigo.shared.scenegraph.Layer
import indigo.shared.config.GameConfig
import indigo.shared.datatypes.RGBA
import indigo.shared.scenegraph.Graphic
import indigo.shared.datatypes.Rectangle
import indigo.shared.materials.Material
import indigo.shared.materials.BlendMaterial
import indigo.shared.scenegraph.Shape
import indigo.shared.datatypes.Size
import indigo.shared.datatypes.Fill
import indigo.shared.scenegraph.Text
import indigo.shared.datatypes.Font
import indigo.shared.collections.Batch
import indigo.shared.scenegraph.TextBox
import indigo.shared.datatypes.Pixels
import indigo.shared.config.AdvancedGameConfig
import indigo.shared.datatypes.TextStroke
import indigo.shared.scenegraph.SceneNode
import indigo.shared.scenegraph.Group
import indigo.shared.datatypes.Stroke
import indigo.shared.datatypes.TextStyle
import indigo.shared.datatypes.TextAlignment

import indigo.scenes.Scene
import indigo.scenes.SceneName
import indigo.shared.collections.NonEmptyList

import tetris.models.ViewModel
import tetris.models.GameModel

import tetris.scenes.StartScene
import tetris.scenes.GameScene
import tetris.scenes.EndScene

final case class MyStartupData(maxParticles: Int)

object BootData

@JSExportTopLevel("IndigoGame")
object TetrisGame extends IndigoGame[Unit, MyStartupData, GameModel, ViewModel]:

  override def setup(
      bootData: Unit,
      assetCollection: AssetCollection,
      dice: Dice
  ): Outcome[Startup[MyStartupData]] = Outcome(
    Startup.Success(MyStartupData(256))
  )

  override def updateViewModel(
      context: FrameContext[MyStartupData],
      model: GameModel,
      viewModel: ViewModel
  ): GlobalEvent => Outcome[ViewModel] = (e: GlobalEvent) => Outcome(viewModel)

  override def updateModel(
      context: FrameContext[MyStartupData],
      model: GameModel
  ): GlobalEvent => Outcome[GameModel] = (e: GlobalEvent) => Outcome(model)

  override def present(
      context: FrameContext[MyStartupData],
      model: GameModel,
      viewModel: ViewModel
  ): Outcome[SceneUpdateFragment] = Outcome(SceneUpdateFragment.empty)

  override def scenes(
      bootData: Unit
  ): NonEmptyList[Scene[MyStartupData, GameModel, ViewModel]] = NonEmptyList(
    StartScene,
    GameScene,
    EndScene
  )

  override def initialViewModel(
      startupData: MyStartupData,
      model: GameModel
  ): Outcome[ViewModel] = Outcome(ViewModel())

  override def initialModel(startupData: MyStartupData): Outcome[GameModel] =
    Outcome(GameModel())

  override def eventFilters: EventFilters = EventFilters.Restricted

  override def initialScene(bootData: Unit): Option[SceneName] = Option(
    SceneName("start")
  )

  private val magnificationLevel = 1
  private val viewportWidth = 400 * magnificationLevel
  private val viewportHeight = 610 * magnificationLevel

  val config: GameConfig =
    GameConfig(
      viewport = GameViewport(viewportWidth, viewportHeight),
      clearColor = RGBA.White,
      magnification = magnificationLevel
    )

  override def boot(flags: Map[String, String]): Outcome[BootResult[Unit]] =
    Outcome(BootResult(config, BootData))
