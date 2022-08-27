const Coin = artifacts.require('Coin');

module.exports = (deployer) => {
  deployer.deploy(Coin);
};
