const FILLED = 2;

export default class Board {
  constructor({ width, height }) {
    this.width = width;
    this.height = height;

    this.cells = [...Array(this.height)]
      .map(() => Array(this.width).fill(0));
  }

  touchesBottom(positionX, positionY) {
    return positionY + 1 === this.height || this.cells[positionY + 1][positionX] === FILLED;
  }

  touchesRight(positionX, positionY) {
    return positionX + 1 === this.width || this.cells[positionY][positionX + 1] === FILLED;
  }

  touchesLeft(positionX, positionY) {
    return positionX === 0 || this.cells[positionY][positionX - 1] === FILLED;
  }

  accumulate(block) {
    block.filledPositions()
      .forEach(([x, y]) => {
        this.cells[y][x] = FILLED;
      });
  }

  isOutOfBound(positionX, positionY) {
    return positionX < 0 || positionX >= this.width || positionY < 0 || positionY >= this.height;
  }

  isAlreadyFilled(positionX, positionY) {
    return this.cells[positionY][positionX] === FILLED;
  }

  illegalPoint(positionX, positionY) {
    return this.isOutOfBound(positionX, positionY) || this.isAlreadyFilled(positionX, positionY);
  }

  findFilledRows() {
    return this.cells.map((r, i) => {
      if (r.every((e) => e === 2)) {
        return i;
      }

      return null;
    }).filter((i) => i);
  }

  createNewRows(count) {
    return [...Array(count)].map(() => (
      [...Array(this.width)].fill(0)
    ));
  }

  filledRowsCleared() {
    return this.cells.filter((r) => !r.every((e) => e === FILLED));
  }

  flush() {
    const filledRows = this.findFilledRows();
    const newRows = this.createNewRows(filledRows.length);
    this.cells = [
      ...newRows,
      ...this.filledRowsCleared(),
    ];
  }
}
