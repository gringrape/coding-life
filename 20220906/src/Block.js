import shapes from './shapes';

function clone(original) {
  const copy = JSON.parse(JSON.stringify(original));
  return copy;
}

export default class Block {
  positionX = 0;

  positionY = 0;

  constructor({ type }) {
    this.shape = clone(shapes[type]);
    this.shapeHeight = this.shape.length;
    this.shapeWidth = this.shape[0].length;
  }

  fall() {
    this.positionY += 1;
  }

  touchesBottom(board) {
    return this.shape.some((row, y) => (
      row.some((_, x) => (
        this.shape[y][x] === 1 && board.touchesBottom(x + this.positionX, y + this.positionY)
      ))
    ));
  }

  filledPositions() {
    const result = [];

    for (let i = 0; i < this.shapeHeight; i += 1) {
      for (let j = 0; j < this.shapeWidth; j += 1) {
        if (this.shape[i][j] === 1) {
          result.push([this.positionX + j, this.positionY + i]);
        }
      }
    }

    return result;
  }

  canMoveRight(board) {
    return !this.shape.some((row, y) => (
      row.some((_, x) => (
        this.shape[y][x] === 1 && board.touchesRight(x + this.positionX, y + this.positionY)
      ))
    ));
  }

  moveRight() {
    this.positionX += 1;
  }

  canMoveLeft(board) {
    return !this.shape.some((row, y) => (
      row.some((_, x) => (
        this.shape[y][x] === 1 && board.touchesLeft(x + this.positionX, y + this.positionY)
      ))
    ));
  }

  moveLeft() {
    this.positionX -= 1;
  }

  rotatedShape() {
    const shape = [...Array(this.shapeHeight)]
      .map(() => [...Array(this.shapeWidth)].fill(0));

    for (let i = 0; i < this.shapeHeight; i += 1) {
      for (let j = 0; j < this.shapeWidth; j += 1) {
        shape[i][j] = this.shape[j][this.shapeHeight - i - 1];
      }
    }

    return shape;
  }

  rotate() {
    this.shape = this.rotatedShape();
  }

  canRotate(board) {
    const shape = this.rotatedShape();
    return !shape.some((row, y) => (
      row.some((_, x) => (
        shape[y][x] === 1 && board.illegalPoint(x + this.positionX, y + this.positionY)
      ))
    ));
  }
}
