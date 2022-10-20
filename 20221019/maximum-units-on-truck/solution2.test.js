function solution(string) {
  const counts = {};

  [...string].forEach((letter) => {
    if (!counts[letter]) {
      counts[letter] = 0;
    }

    counts[letter] += 1;
  });

  function maxLengthOfPalindrome(index = 0, hadOddLetter = false) {
    const count = Object.values(counts)[index];

    if (index === Object.values(counts).length) {
      return 0;
    }

    if (!hadOddLetter && count % 2 === 1) {
      return count + maxLengthOfPalindrome(index + 1, true);
    }

    if (count % 2 === 0) {
      return count + maxLengthOfPalindrome(index + 1, hadOddLetter);
    }

    if (count % 2 === 1) {
      return count - 1 + maxLengthOfPalindrome(index + 1, hadOddLetter);
    }
  }

  return maxLengthOfPalindrome();
}

test('sample', () => {
  expect(solution('abccccdd')).toBe(7);
});
