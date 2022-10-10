/* eslint-disable no-bitwise */
class Bits {
  constructor(bits) {
    this.number = parseInt(bits, 2);
  }

  clearBits({ fromIndex, toIndex }) {
    const mask = ((1 << toIndex + 1) - 1) - ((1 << fromIndex) - 1);
    const result = this.number ^ mask;
    return new Bits(result.toString(2));
  }

  insertBits({ target, fromIndex }) {
    const result = this.number + (parseInt(target, 2) << fromIndex);
    return new Bits(result.toString(2));
  }

  toString() {
    return this.number.toString(2);
  }
}

test('insertBits', () => {
  const bits = new Bits('10000000000');

  expect(bits.insertBits({
    target: '10011',
    fromIndex: 2,
  }).toString()).toBe('10001001100');
});

test('clearBits', () => {
  const bits = new Bits('10001111100');

  expect(bits.clearBits({
    fromIndex: 2,
    toIndex: 6,
  }).toString()).toBe('10000000000');
});

test('clear and insert', () => {
  const number = '10001111100';
  const bits = new Bits(number);

  const target = '10011';

  const result = bits
    .clearBits({
      fromIndex: 2,
      toIndex: 2 + target.length - 1,
    })
    .insertBits({
      target,
      fromIndex: 2,
    }).toString();

  expect(result).toBe('10001001100');
});
