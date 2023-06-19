import { configDotenv } from 'dotenv';

configDotenv();

const { log: print } = console;

function main() {
  const commandLineArguments = process.argv.slice(2);

  print(process.env.URL);
  print(commandLineArguments);
}

main();
