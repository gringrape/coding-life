import {
  Observable, interval, map, takeWhile,
} from 'rxjs';

const { log } = console;

// 1. Observable

const observable = new Observable((subscriber) => {
  subscriber.next(1);
  subscriber.next(2);
  subscriber.next(3);
  setTimeout(() => {
    subscriber.next(4);
  }, 1000);
  setTimeout(() => {
    subscriber.next(5);
    subscriber.complete();
  }, 3000);
});

observable.subscribe((x) => {
  log(x);
});

// 2. interval

const observable2 = interval(1000)
  .pipe(
    map((_, index) => index + 1),
    takeWhile((v) => v < 10),
  );

observable2.subscribe((x) => {
  log(`두번째 카운트: ${x}`);
});

// 3. report
const TOTAL = 10;
const messages = interval(1000)
  .pipe(
    map((_, index) => index + 1),
    takeWhile((v) => v <= TOTAL),
    map((v) => ({
      step: v,
      total: TOTAL,
      data: v < TOTAL
        ? null
        : '보고서 삐리삐리',
    })),
  );

const steps = messages.pipe(
  map((message) => {
    const { step, total, data } = message;
    if (step < total) {
      return `${step * 10}% 처리 중`;
    }
    return data;
  }),
);

steps.subscribe((step) => {
  log(step);
});
