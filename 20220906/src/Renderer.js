import Block from './Block';
import Board from './Board';

import shapes from './shapes';

export default class Renderer {
  width = 480;

  height = 640;

  cellSize = 40;

  time = 0;

  constructor(canvas) {
    this.canvas = canvas;
    this.context = canvas.getContext('2d');
    this.board = new Board({
      width: this.width / this.cellSize,
      height: this.height / this.cellSize,
    });

    this.createNewBlock();
  }

  renderBackground() {
    this.context.fillStyle = 'black';
    this.context.fillRect(0, 0, this.width, this.height);
  }

  renderBoard() {
    for (let i = 0; i < this.board.width; i += 1) {
      for (let j = 0; j < this.board.height; j += 1) {
        if (this.board.cells[j][i] === 0) {
          this.context.strokeStyle = 'rgba(255, 255, 255, 0.1)';
          const { cellSize } = this;
          this.context.strokeRect(i * cellSize, j * cellSize, cellSize, cellSize);
        }

        if (this.board.cells[j][i] === 2) {
          this.context.fillStyle = 'grey';
          const { cellSize } = this;
          this.context.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
        }
      }
    }
  }

  renderBlock() {
    const { positionX, positionY, shape } = this.block;

    for (let i = 0; i < shape.length; i += 1) {
      for (let j = 0; j < shape.length; j += 1) {
        const value = shape[j][i];
        if (value === 1) {
          const cellPositionX = (positionX + i) * this.cellSize;
          const cellPositionY = (positionY + j) * this.cellSize;

          this.context.fillStyle = 'green';
          this.context.fillRect(
            cellPositionX,
            cellPositionY,
            this.cellSize,
            this.cellSize,
          );
          this.context.strokeStyle = 'rgba(0, 0, 0, 0.3)';
          this.context.strokeRect(
            cellPositionX,
            cellPositionY,
            this.cellSize,
            this.cellSize,
          );
        }
      }
    }
  }

  createNewBlock() {
    const types = Object.keys(shapes);

    const randomIndex = Math.floor(types.length * Math.random());

    this.block = new Block({ type: types[randomIndex] });
  }

  update() {
    if (this.block.touchesBottom(this.board)) {
      this.board.accumulate(this.block);
      this.board.flush();
      this.createNewBlock();
      return;
    }

    if (this.time % 15 === 0) {
      this.moveDown();
    }
  }

  moveDown() {
    if (!this.block.touchesBottom(this.board)) {
      this.block.fall();
    }
  }

  moveBlockRight() {
    if (this.block.canMoveRight(this.board)) {
      this.block.moveRight();
    }
  }

  moveBlockLeft() {
    if (this.block.canMoveLeft(this.board)) {
      this.block.moveLeft();
    }
  }

  rotateBlock() {
    if (this.block.canRotate(this.board)) {
      this.block.rotate();
    }
  }

  accelerate() {
    for (let i = 0; i < 3; i += 1) {
      this.moveDown();
    }
  }

  bindEvents() {
    document.addEventListener('keydown', (event) => {
      const { key } = event;

      if (key === 'ArrowRight') {
        this.moveBlockRight();
      }

      if (key === 'ArrowLeft') {
        this.moveBlockLeft();
      }

      if (key === 'ArrowUp') {
        this.rotateBlock();
      }

      if (key === 'ArrowDown') {
        this.accelerate();
      }
    });
  }

  render() {
    requestAnimationFrame(() => this.render());

    this.renderBackground();
    this.renderBoard();
    this.renderBlock();

    this.update();

    this.time = (this.time + 1) % 1000000;
  }
}
