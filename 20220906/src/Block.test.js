import Board from './Board';
import Block from './Block';

describe('Block', () => {
  let block;

  beforeEach(() => {
    block = new Block({ type: 'L' });
  });

  describe('fall', () => {
    it('moves position down', () => {
      expect(block.positionY).toBe(0);

      block.fall();

      expect(block.positionY).toBe(1);

      block.fall();

      expect(block.positionY).toBe(2);
    });
  });

  describe('touchesBottom', () => {
    const positionY = 7;
    let board;

    beforeEach(() => {
      board = new Board({ width: 4, height: 10 });
    });

    it('returns true if touched', () => {
      for (let i = 0; i < positionY; i += 1) {
        block.fall();
      }

      expect(block.touchesBottom(board)).toBeTruthy();
    });
  });

  describe('canMoveRight', () => {
    let board;

    beforeEach(() => {
      board = new Board({ width: 2, height: 10 });
    });

    it('returns false meeting wall', () => {
      expect(block.canMoveRight(board)).toBeFalsy();
    });
  });

  describe('moveRight', () => {
    let board;

    beforeEach(() => {
      board = new Board({ width: 4, height: 14 });
    });

    it('moves right', () => {
      expect(block.positionX).toBe(0);
      expect(block.canMoveRight(board)).toBeTruthy();

      block.moveRight();

      expect(block.positionX).toBe(1);
      expect(block.canMoveRight(board)).toBeTruthy();

      block.moveRight();

      expect(block.positionX).toBe(2);
      expect(block.canMoveRight(board)).toBeFalsy();
    });
  });

  describe('canMoveLeft', () => {
    let board;

    beforeEach(() => {
      board = new Board({ width: 3, height: 10 });
    });

    it('returns false meeting wall', () => {
      expect(block.canMoveLeft(board)).toBeFalsy();

      block.moveRight();

      expect(block.canMoveLeft(board)).toBeTruthy();
    });
  });

  describe('moveLeft', () => {
    beforeEach(() => {
      block.moveRight();
    });

    it('returns false meeting wall', () => {
      expect(block.positionX).toBe(1);

      block.moveLeft();

      expect(block.positionX).toBe(0);
    });
  });

  describe('rotate', () => {
    const block1 = new Block({ type: 'L' });

    block1.rotate();

    expect(block1.shape).toEqual([
      [0, 0, 0],
      [0, 0, 1],
      [1, 1, 1],
    ]);
  });
});
