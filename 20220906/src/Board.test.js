import Block from './Block';
import Board from './Board';

describe('Board', () => {
  it('creates', () => {
    const board = new Board({ width: 2, height: 2 });

    expect(board.cells).toEqual([
      [0, 0],
      [0, 0],
    ]);
  });

  test('accumulate', () => {
    const board = new Board({ width: 3, height: 5 });

    const block = new Block({ type: 'L' });

    block.fall();
    block.fall();

    board.accumulate(block);

    expect(board.cells).toEqual([
      [0, 0, 0],
      [0, 0, 0],
      [2, 0, 0],
      [2, 0, 0],
      [2, 2, 0],
    ]);
  });

  test('touchesBottom', () => {
    const board = new Board({ width: 3, height: 6 });

    const block = new Block({ type: 'L' });

    block.fall();
    block.fall();
    block.fall();

    board.accumulate(block);

    expect(board.touchesBottom(0, 3)).toBeTruthy();
  });

  test('touchRight', () => {
    const board = new Board({ width: 3, height: 6 });

    expect(board.touchesRight(2, 0)).toBeTruthy();
    expect(board.touchesRight(1, 0)).toBeFalsy();
  });

  test('touchLeft', () => {
    const board = new Board({ width: 3, height: 3 });

    expect(board.touchesLeft(0, 0)).toBeTruthy();
    expect(board.touchesLeft(1, 0)).toBeFalsy();

    const block = new Block({ type: 'L' });

    board.accumulate(block);

    expect(board.touchesLeft(1, 0)).toBeTruthy();
  });

  test('filledRowsCleard', () => {
    const board = new Board({ width: 3, height: 3 });

    const block = new Block({ type: 'L' });

    board.accumulate(block);

    expect(board.filledRowsCleared()).toEqual([
      [2, 0, 0],
      [2, 0, 0],
      [2, 2, 0],
    ]);
  });
});
