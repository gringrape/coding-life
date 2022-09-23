import toBinarySting from './toBinaryString';

const context = describe;

describe('toBinaryString', () => {
  context('with number', () => {
    it('retunrs binary representation of the number', () => {
      expect(toBinarySting(0)).toBe('0');
      expect(toBinarySting(1)).toBe('1');
    });
  });

  context('with expression', () => {
    it('retunrs binary representation of number', () => {
      expect(toBinarySting('12 & 25')).toBe('1000');
    });
  });
});
