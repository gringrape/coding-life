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

function targetScoresGroup({ arrowsCount, enemyScores }) {
  const shoot = (arrows, index = 0, scores = []) => {
    if (arrows < 0) {
      return [];
    }

    if (arrows === 0) {
      return [
        scores.concat(Array(11 - index).fill(0)),
      ];
    }

    if (index === 10) {
      return [
        [...scores, arrows],
      ];
    }

    const winScore = enemyScores[index] + 1;
    return [
      ...shoot(arrows, index + 1, [...scores, 0]),
      ...shoot(arrows - winScore, index + 1, [...scores, winScore]),
    ];
  };

  return shoot(arrowsCount);
}

test('targetScoresGroup', () => {
  expect(targetScoresGroup({
    arrowsCount: 5,
    enemyScores: [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  })).toContainEqual([3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0]);

  expect(targetScoresGroup({
    arrowsCount: 5,
    enemyScores: [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  })).toContainEqual([0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0]);

  expect(targetScoresGroup({
    arrowsCount: 10,
    enemyScores: [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3],
  })).toContainEqual([1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2]);
});

function totalScoreDifference(targetScores, enemyTargetScores) {
  const indicies = [...Array(targetScores.length)].map((_, i) => i);

  return indicies.reduce((totalScore, index) => {
    if (targetScores[index] === 0 && enemyTargetScores[index] === 0) {
      return totalScore;
    }

    const score = 10 - index;
    return targetScores[index] > enemyTargetScores[index]
      ? totalScore + score
      : totalScore - score;
  }, 0);
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

function solution({ arrowsCount, enemyScores }) {
  const [bestTargetScores] = targetScoresGroup({ arrowsCount, enemyScores })
    .filter((i) => totalScoreDifference(i, enemyScores) > 0)
    .sort(descending(lastNonzeroIndex))
    .sort(descending((x) => totalScoreDifference(x, enemyScores)));

  return bestTargetScores || [-1];
}

test('sample', () => {
  expect(solution({
    arrowsCount: 5,
    enemyScores: [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
  }))
    .toEqual([0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0]);

  expect(solution({
    arrowsCount: 9,
    enemyScores: [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1],
  }))
    .toEqual([1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0]);

  expect(solution({
    arrowsCount: 10,
    enemyScores: [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3],
  }))
    .toEqual([1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2]);

  expect(solution({
    arrowsCount: 1,
    enemyScores: [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
  }))
    .toEqual([-1]);
});

// #. Bad.
// - shot 을 테스트 할 수 없었던게 패착. 가장 큰 패배 요인.
//  => 디버깅에 엄청난 시간.
//  => 무지성으로 막 결과를 여러개 프린트해봄. => 이걸 안할 수 있다면
//  => 이러면 혼이 나간다, 포기하게 된다

// #. Good.
// - 최소한 기도메타로 코드 수정은 안함.
// - tricky 한 로직은 별도의 함수로 분리후 테스트함.
