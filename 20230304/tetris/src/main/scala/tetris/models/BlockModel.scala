package tetris.models

import indigo.shared.datatypes.Point
import indigo.shared.time.Seconds

final class BlockModel(
    private var positionX: Double = 1,
    private var positionY: Double = 1
):
  def cellX = this.positionX.toInt
  def cellY = this.positionY.toInt

  def moveDown(duration: Seconds) =
    val velocityY = 10
    new BlockModel(positionX, positionY + duration.toDouble * velocityY)
