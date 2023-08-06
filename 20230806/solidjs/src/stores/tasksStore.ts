import { createStore } from 'solid-js/store';

export type Task = {
  title: string;
};

const [tasks, setTasks] = createStore<Task[]>([]);

export default {
  tasks,
  setTasks,
};
