const canvas = document.getElementById('game');
const context = canvas.getContext('2d');

function clearScreen() {
  context.clearRect(0, 0, canvas.width, canvas.height);
}

const Background = {
  render() {
    context.fillStyle = 'black';
    context.fillRect(0, 0, canvas.width, canvas.height);
  },
};

const Block = {
  x: 0,
  y: 0,
  size: 30,
  event: null,
  shape: [
    [1, 0, 0],
    [1, 0, 0],
    [1, 1, 0],
  ],
  advance() {
    this.y += 3;
  },
  accelerate() {
    this.y += 3 * this.size;
  },
  moveLeft() {
    this.x -= this.size;
  },
  moveRight() {
    this.x += this.size;
  },
  rotate() {
    const transposed = Array(3).fill()
      .map(() => [0, 0, 0]);

    for (let x = 0; x < 3; x += 1) {
      for (let y = 0; y < 3; y += 1) {
        transposed[x][y] = this.shape[y][x];
      }
    }

    transposed.forEach((r) => {
      r.reverse();
    });

    this.shape = transposed;
  },
  draw() {
    context.fillStyle = 'blue';
    this.shape.forEach((line, c) => {
      line.forEach((e, r) => {
        if (e) {
          context.fillRect(
            this.x + this.size * r,
            this.y + this.size * c,
            this.size,
            this.size,
          );
        }
      });
    });
  },
  render() {
    this.advance();
    this.draw();
  },
};

function render(...components) {
  components.forEach((component) => {
    component.render();
  });
}

function animate() {
  clearScreen();

  requestAnimationFrame(animate);

  render(
    Background,
    Block,
  );
}

function bindEvents() {
  document.addEventListener('keydown', (event) => {
    const { key } = event;

    if (key === 'ArrowUp') {
      Block.rotate();
    }

    if (key === 'ArrowDown') {
      Block.accelerate();
    }

    if (key === 'ArrowLeft') {
      Block.moveLeft();
    }

    if (key === 'ArrowRight') {
      Block.moveRight();
    }
  });
}

function main() {
  animate();
  bindEvents();
}

main();
