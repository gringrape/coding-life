function countMaximumToys(boxTypes, truckSize) {
  boxTypes.sort((a, b) => b[1] - a[1]);

  function countToys(capacity = truckSize, index = 0) {
    if (capacity === 0) {
      return 0;
    }

    const [boxCount, toyCount] = boxTypes[index];

    if (capacity < boxCount) {
      return capacity * toyCount + countToys(0, index + 1);
    }

    return boxCount * toyCount + countToys(
      capacity - boxCount,
      index + 1,
    );
  }

  return countToys();
}

test('sample', () => {
  const boxTypes = [[5, 10], [2, 5], [4, 7], [3, 9]];
  const truckSize = 10;

  expect(countMaximumToys(boxTypes, truckSize)).toBe(91);
});
