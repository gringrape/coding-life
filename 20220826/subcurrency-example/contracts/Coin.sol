// SPDX-License-Identifier: MIT
pragma solidity ^0.8.16;

contract Coin {
  address public minter;

  mapping (address => uint) public balances;

  constructor() {
    minter = msg.sender;
  }

  function mint(address receiver, uint amount) public {
    require(msg.sender == minter);
    balances[receiver] += amount;
  }

  error InsufficientBalance(uint requested, uint available);

  function send(address receiver, uint amount) public {
    if (balances[msg.sender] < amount) {
      revert InsufficientBalance({
        requested: amount,
        available: balances[msg.sender]
      });
    }
    balances[msg.sender] -= amount;
    balances[receiver] += amount;    
  }
}
