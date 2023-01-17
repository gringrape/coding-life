import amqlib from 'amqplib';

const { log: print } = console;

async function sendMessage(connection, queue, message) {
  const channel = await connection.createChannel();

  setInterval(() => {
    channel.sendToQueue(queue, Buffer.from(message));

    print(`message sent: ${message}`);
  }, 1000);
}

async function receiveMessage(connection, queue) {
  const channel = await connection.createChannel();
  channel.assertQueue(queue);
  channel.consume(queue, (message) => {
    print('메시지 도착!');
    print(message.content.toString());
  });
}

async function main() {
  const url = 'amqp://localhost';

  const connection = await amqlib.connect(url);

  print('message server is connected!');

  const queue = 'greetings';
  receiveMessage(connection, queue);
  sendMessage(connection, queue, 'Hello, RabbitMQ');
}

main();
