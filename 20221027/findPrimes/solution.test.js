function range(from, to) {
  if (from > to) {
    return [];
  }

  return [...Array(to - from).keys()]
    .map((i) => i + from);
}

function shuffle(items, item) {
  return range(0, items.length + 1)
    .map((i) => (
      [...items.slice(0, i), item, ...items.slice(i)]
    ));
}

function permutation(items) {
  if (items.length === 0) {
    return [];
  }

  const [item, ...rest] = items;

  return [
    ...permutation(rest),
    [item],
    ...permutation(rest).flatMap((i) => shuffle(i, item)),
  ];
}

function isPrime(number) {
  if (number < 2) {
    return false;
  }

  return range(2, Math.floor(number ** 0.5) + 1)
    .every((i) => number % i !== 0);
}

function distinct(array) {
  return [...new Set(array)];
}

function generateNumbers(paper) {
  return permutation(paper.split(''))
    .map((i) => Number(i.join('')));
}

function solution(paper) {
  const numbers = generateNumbers(paper);

  return distinct(numbers).filter(isPrime).length;
}

test('sample', () => {
  expect(solution('17')).toBe(3);
});
