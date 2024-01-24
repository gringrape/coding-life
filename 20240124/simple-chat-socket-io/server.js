import { Server } from 'socket.io';

function main() {
  const io = new Server({ /* options */ });

  io.on('connection', (socket) => {
    socket.send('hello, brother!');

    socket.on('message', () => {
      socket.send("I'm fine!");
    });
  });

  io.listen(3000);
}

main();
