import LRUCache from './LRUCache';

describe('LRUCache', () => {
  const entries = [
    { key: 1, value: 1 }, { key: 2, value: 2 }, { key: 3, value: 3 },
  ];

  describe('get', () => {
    it('updates the priority', () => {
      const cache = new LRUCache(3);

      cache.put(1, 1);
      cache.put(2, 2);
      cache.put(3, 3);

      cache.get(1);

      cache.put(4, 4);

      expect(cache.get(2)).toBe(LRUCache.NOT_EXIST);
    });
  });

  describe('put', () => {
    it('evicts the least recently used', () => {
      const cache = new LRUCache(entries.length - 1);

      entries.forEach(({ key, value }) => {
        cache.put(key, value);
      });

      const [first] = entries;
      const value = cache.get(first.key);

      expect(value).toBe(LRUCache.NOT_EXIST);
    });

    it('updates priority with existed key', () => {
      const cache = new LRUCache(3);

      cache.put(1, 1);
      cache.put(2, 2);
      cache.put(3, 3);

      cache.put(2, 4);

      expect(cache.get(2)).toBe(4);
      expect(cache.get(1)).toBe(1);
      expect(cache.get(3)).toBe(3);
    });
  });

  test('sample', () => {
    const methodNames = ['put', 'put', 'get', 'put', 'get', 'put', 'get', 'get', 'get'];
    const argumentsList = [[1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]];
    const expectedValues = [undefined, undefined, 1, undefined, -1, undefined, -1, 3, 4];

    const cache = new LRUCache(2);

    methodNames.forEach((name, i) => {
      const args = argumentsList[i];
      const expectedValue = expectedValues[i];

      expect(cache[name](...args)).toBe(expectedValue);
    });
  });

  test('sample 2', () => {
    const methodNames = ['get', 'get', 'put', 'get', 'put', 'put', 'put', 'put', 'get', 'put'];
    const argumentsList = [
      [6], [8], [12, 1], [2], [15, 11], [5, 2], [1, 15], [4, 2], [5], [15, 15],
    ];
    const expectedValues = [
      -1, -1, undefined, -1, undefined, undefined, undefined, undefined, -1, undefined,
    ];

    const cache = new LRUCache(1);

    methodNames.forEach((name, i) => {
      const args = argumentsList[i];
      const expectedValue = expectedValues[i];

      expect(cache[name](...args)).toBe(expectedValue);
    });
  });
});
