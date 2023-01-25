import server from './server';

const { log: print } = console;

function main() {
  const port = 3000;

  server.listen(port, () => {
    print(`Server is ready on port: ${port}`);
  });
}

main();
