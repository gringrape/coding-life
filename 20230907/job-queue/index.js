import { SequentialTaskQueue } from 'sequential-task-queue';

const queue = new SequentialTaskQueue();

const job = () => new Promise((resolve) => {
  setTimeout(() => {
    console.log('hello');
    resolve();
  }, 1000);
});

queue.push(job);
queue.push(job);
queue.push(job);
queue.push(job);
queue.push(job);
queue.push(job);
