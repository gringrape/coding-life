package tetris

package models

final class GameModel(var block: BlockModel = BlockModel()):
  def update(newBlock: BlockModel) =
    GameModel(newBlock)
