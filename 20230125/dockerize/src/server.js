import express from 'express';

const server = express();

server.get('/', (request, response) => {
  response.send('Hello, World!');
});

export default server;
