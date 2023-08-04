const { log: print } = console;

const express = require('express');

function main() {
  const PORT = 8080;
  const HOST = '0.0.0.0';

  const app = express();

  app.get('/', (req, res) => {
    res.send('Hello World');
  });

  app.listen(PORT, HOST, () => {
    print(`Running on http://${HOST}:${PORT}`);

    setTimeout(() => {
      throw Error('이 어플리케이션은 폭파되었다');
    }, 3000);
  });
}

main();

process.on('uncaughtException', () => {
  print('어플리케이션이 폭파되었습니다!!! 대피하세요!!');
});
