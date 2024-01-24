import { io } from 'socket.io-client';

const { log: print } = console;

function main() {
  const socket = io('ws://localhost:3000');
  socket.on('message', (message) => {
    print(`Server: ${message}`);

    if (message.includes('hello')) {
      socket.send('how are you?');
      print('Me: how are you?');
    }
  });
}

main();
