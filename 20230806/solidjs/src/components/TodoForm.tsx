import useTaskTitle from '../hooks/useTaskTitle';
import useTaskStore from '../hooks/useTaskStore';

type ChangeEvent = {
  target: {
    value: string;
  }
};

export default function TodoForm() {
  const { title, changeTitle } = useTaskTitle();
  const { addNewTask } = useTaskStore();

  const handleChange = (e: ChangeEvent) => {
    const { value } = e.target;
    changeTitle(value);
  };

  const handleClick = () => {
    addNewTask();
  };

  return (
    <div>
      <input
        type="text"
        value={title()}
        onInput={handleChange}
      />
      <button onClick={handleClick}>추가</button>
    </div>
  );
}
