const HDWalletProvider = require('@truffle/hdwallet-provider');

function createWalletProvider() {
  return new HDWalletProvider({
    privateKeys: [process.env.HDWP_PRIVATE_KEY],
    providerOrUrl: process.env.HDWP_ENDPOINT,
  });
}

module.exports = {
  networks: {
    development: {
     host: "127.0.0.1",     // Localhost (default: none)
     port: 8545,                  // Standard Ethereum port (default: none)
     network_id: "*",             // Any network (default: none)
     provider: createWalletProvider,
    },
  },
  compilers: {
    solc: {
      version: "0.8.16",      // Fetch exact version from solc-bin (default: truffle's version)
    }
  },
};
