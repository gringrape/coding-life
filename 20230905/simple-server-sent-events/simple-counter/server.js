import express from 'express';

import cors from 'cors';

const app = express();

app.use(cors());

const { log } = console;

app.get('/', (req, res) => {
  let count = 0;

  res.writeHead(200, {
    'Content-Type': 'text/event-stream', // 요기!
    Connection: 'keep-alive',
    'Cache-Control': 'no-cache',
  });

  const interval = setInterval(() => {
    count += 1;
    res.write(`data: {"count": ${count}}\n\n`);
  }, 1000);

  res.on('close', () => {
    clearInterval(interval);
  });
});

const port = 3000;
app.listen(port, () => {
  log(`Example app listening on port ${port}`);
});
