import { render } from 'solid-js/web';

import App from './components/App';

function main() {
  const root = document.getElementById('app');

  if (!root) {
    throw Error('Container not found');
  }

  render(() => <App />, root);
}

main();
