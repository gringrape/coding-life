function initializeCanvas() {
  const canvas = document.querySelector('canvas');
  if (!canvas) {
    throw Error('not initialized');
  }
  return canvas;
}

function resizeCanvas() {
  const canvas = initializeCanvas();
  if (!canvas.parentElement) {
    return;
  }

  const {
    offsetWidth: parentWidth,
    offsetHeight: parentHeight,
  } = canvas.parentElement;

  canvas.setAttribute('width', `${parentWidth}`);
  canvas.setAttribute('height', `${parentHeight}`);
}

function drawRect() {
  const canvas = initializeCanvas();
  const context = canvas.getContext('2d');
  if (!context) {
    return;
  }

  context.beginPath();
  context.rect(20, 40, 50, 50);
  context.fillStyle = 'green';
  context.fill();
  context.closePath();
}

function main() {
  drawRect();
}

const handleLoad = () => {
  resizeCanvas();
  main();
};

const handleResize = () => {
  resizeCanvas();
};

window.onload = handleLoad;
window.onresize = handleResize;
