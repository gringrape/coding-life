/* eslint-disable no-constant-condition */

import createPrompt from 'prompt-sync';

import toBinaryString from './toBinaryString.js';

const { log: print } = console;

const prompt = createPrompt();

async function main() {
  print('Bitwise operations REPL');
  print('------------------------------');

  while (true) {
    const expression = prompt('> ');

    if (expression === 'exit') {
      break;
    }

    print(toBinaryString(expression));
  }

  print('bye bye~');
}

main();
