import amqp from 'amqplib';

async function main() {
  const connection = await amqp.connect('amqp://127.0.0.1');
  const channel = await connection.createChannel();

  channel.sendToQueue('test-queue', Buffer.from('hello, this is tester!'));
}

main();
