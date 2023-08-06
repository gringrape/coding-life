import { batch } from 'solid-js';

import titleState from '../stores/titleState';
import tasksStore from '../stores/tasksStore';

export default function useTaskStore() {
  const { title, setTitle } = titleState;

  const { tasks, setTasks } = tasksStore;

  const addNewTask = () => {
    batch(() => {
      setTasks(tasks.length, {
        title: title(),
      });
      setTitle('');
    });
  };

  const removeTask = (index: number) => {
    setTasks((prev) => prev.filter((_, i) => i !== index));
  };

  return {
    tasks,
    addNewTask,
    removeTask,
  };
}
