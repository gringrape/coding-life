// #. 문제분석
// ##. 구하는 것
// - 라이언(이전 대회 우승자)이 가장 큰 점수차이로 우승하려면 어떤 점수 과녁에 맞춰야 하는지
// ##. 주어진 것
// - 라이언이 쏠 수 있는 화살 개수
// - 어피치(파트너)가 맞힌 과녁 점수 배열

// #. 조건
// ##. 과녁 점수 계산
// - '과녁'에 '화살'을 더 많이 맞힌 사람이 과녁점수 만큼 점수를 가져감.
//  ex) 10 점 과녁, 라이언 3, 어피치 2 => 라이언 10점
// - 과녁에 맞힌 화살 개수가 같을때, 라이언이 우승자이므로 어피치가 점수를 가져감.
// - 과녁에 맞힌 화살 개수가 0일때, 어느쪽도 점수를 가져가지 않음.
// ##. 최종점수
// - 최종점수가 같은 경우, 어피치가 우승

// # 예시.
// 화살개수: 5개, 어피치: [2,1,1,1,0,0,0,0,0,0,0]
// => [3, 2]
// - 같은 과녁일 경우, 어피치 보다 한발 많아야함.
// - 어느 과녁에서 이길지는 경우의 수.
//  - 화살이 5개라면, 점수가 가장 큰 과녁부터 5개의 과녁만 고려하면 됨.

// 어피치를 이긴다 => [3, 2, 2, 2, 1, 1, 1, 1, 1, 1]
// 10, 9 => 19
// 9, 8, 6 => 23
// 8, 7, 6 => 21
// 화살을 각 과녁에 분배하는 경우의 수 => 그 중에 합 최대.

// [19
// 10에서 이긴다 => 10, 9
// 10에서 진다
//   - 9에서 이긴다 => 9, 8, 6
//   - 9에서 진다 =>

function lastNonzeroIndex(numbers) {
  const nonZeroIndex = [...numbers].reverse().findIndex((n) => n !== 0);
  return numbers.length - nonZeroIndex - 1;
}

test('lastNonzeroIndex', () => {
  expect(lastNonzeroIndex([0, 1, 0, 1, 2, 0])).toBe(4);
});

const TARGET_COUNT = 10;

function hitCountsGroup({ arrowsCount, enemyHitCounts }) {
  const shoot = (arrows, index = 0, hitCounts = []) => {
    if (arrows < 0) {
      return [];
    }

    if (arrows === 0) {
      return [
        hitCounts.concat(Array(TARGET_COUNT - index + 1).fill(0)),
      ];
    }

    if (index === TARGET_COUNT) {
      return shoot(0, index + 1, [...hitCounts, arrows]);
    }

    const winHitCount = enemyHitCounts[index] + 1;
    return [
      ...shoot(arrows, index + 1, [...hitCounts, 0]),
      ...shoot(arrows - winHitCount, index + 1, [...hitCounts, winHitCount]),
    ];
  };

  return shoot(arrowsCount);
}

test('hitCountsGroup', () => {
  expect(hitCountsGroup({
    arrowsCount: 5,
    enemyHitCounts: [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  })).toContainEqual([3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0]);

  expect(hitCountsGroup({
    arrowsCount: 5,
    enemyHitCounts: [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  })).toContainEqual([0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0]);

  expect(hitCountsGroup({
    arrowsCount: 10,
    enemyHitCounts: [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3],
  })).toContainEqual([1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2]);
});

function totalScoreDifference(hitCounts, enemyHitCounts) {
  const targetIndicies = [...Array(hitCounts.length)].map((_, i) => i);

  const scorePairs = targetIndicies.map((i) => {
    const myHitCount = hitCounts[i];
    const enemyHitCount = enemyHitCounts[i];

    if (myHitCount === 0 && enemyHitCount === 0) {
      return [0, 0];
    }

    const score = TARGET_COUNT - i;
    return myHitCount > enemyHitCount
      ? [score, 0]
      : [0, score];
  });

  return scorePairs
    .map(([myScore, enemyScore]) => myScore - enemyScore)
    .reduce((a, b) => a + b, 0);
}

test('scoreDifference', () => {
  expect(totalScoreDifference(
    [3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  )).toBe(4);
  expect(totalScoreDifference(
    [0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0],
    [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  )).toBe(6);
});

function descending(f) {
  return (a, b) => f(b) - f(a);
}

function solution({ arrowsCount, enemyHitCounts }) {
  const [bestHitCounts] = hitCountsGroup({ arrowsCount, enemyHitCounts })
    .filter((i) => totalScoreDifference(i, enemyHitCounts) > 0)
    .sort(descending(lastNonzeroIndex))
    .sort(descending((x) => totalScoreDifference(x, enemyHitCounts)));

  return bestHitCounts || [-1];
}

test('sample', () => {
  expect(solution({
    arrowsCount: 5,
    enemyHitCounts: [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  }))
    .toEqual([0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0]);

  expect(solution({
    arrowsCount: 9,
    enemyHitCounts: [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1],
  }))
    .toEqual([1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0]);

  expect(solution({
    arrowsCount: 10,
    enemyHitCounts: [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3],
  }))
    .toEqual([1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2]);

  expect(solution({
    arrowsCount: 1,
    enemyHitCounts: [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
  }))
    .toEqual([-1]);
});
