const Coin = artifacts.require('Coin');

contract('Coin', (accounts) => {
  let contract;

  const minter = accounts[0];
  const others = accounts.slice(1);

  beforeEach(async () => {
    contract = await Coin.deployed();
  });

  describe('mint', () => {
    const receiver = accounts[0];
    const amount = 10_000;

    context('when minter', () => {
      const from = minter;

      it('sends newly created coin to receiver', async () => {
        await contract.mint.sendTransaction(receiver, amount, { from });

        assert.equal(await contract.balances(receiver), amount);
      });
    });

    context('when not minter', () => {
      const from = others[0];

      it('sending fails', async () => {
        try {
          await contract.mint.sendTransaction(receiver, amount, { from });
        } catch (e) {
          assert.include(e.message, 'revert');
        }
      });
    });
  });

  describe('send', () => {
    context('with enough balance', () => {
      const [sender, receiver] = others;
      const balance = 100_000;
      const amount = 10_000;

      beforeEach(async () => {
        await contract.mint(sender, balance);
      });

      it('sends coins', async () => {
        await contract.send
          .sendTransaction(
            receiver,
            amount,
            { from: sender },
          );

        assert.equal(
          (await contract.balances(sender)).toNumber(),
          balance - amount,
        );

        assert.equal(
          await contract.balances(receiver),
          amount,
        );
      });
    });

    context('with insufficient balance', () => {
      const [sender, receiver] = others;
      const balance = 10_000;
      const amount = 20_000;

      beforeEach(async () => {
        await contract.mint(sender, balance);
      });

      it('sending fails', async () => {
        try {
          await contract.send
            .sendTransaction(receiver, amount, {
              from: sender,
            });
        } catch (e) {
          assert.include(e.message, 'revert');
        }
      });
    });
  });
});
