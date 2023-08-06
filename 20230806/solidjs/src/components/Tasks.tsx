import { For } from 'solid-js';

import useTaskStore from '../hooks/useTaskStore';
import { Task } from '../stores/tasksStore';

const TaskItem = (props: {
  index: number;
  task: Task;
}) => {
  const { removeTask } = useTaskStore();

  const handleClickDelete = () => {
    removeTask(props.index);
  };

  return (
    <div>
      {props.task.title}
      <button onClick={handleClickDelete}>완료</button>
    </div>
  );
};

export default function Tasks() {
  const { tasks } = useTaskStore();

  return (
    <For each={tasks}>
      {(task, index) => (
        <TaskItem index={index()} task={task} />
      )}
    </For>
  );
}
