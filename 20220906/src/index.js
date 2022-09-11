import Renderer from './Renderer';

function main() {
  const canvas = document.getElementById('game');

  const renderer = new Renderer(canvas);

  renderer.bindEvents();

  renderer.render();
}

main();
