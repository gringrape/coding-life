class Alphabet {
  constructor({ excludes }) {
    this.charSet = [...'abcdefghijklmnopqrstuvwxyz']
      .filter((char) => !excludes.includes(char));
  }

  jump(char, offset) {
    const index = this.charSet.indexOf(char);
    const newIndex = (index + offset) % this.charSet.length;
    return this.charSet[newIndex];
  }
}

const encode = (string, skip, offset) => {
  const charSet = new Alphabet({ excludes: skip });

  return [...string]
    .map((c) => charSet.jump(c, offset))
    .join('');
};

test('sample', () => {
  expect(encode('aukks', 'wbqd', 5)).toBe('happy');
});
