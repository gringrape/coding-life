import taskState from '../stores/titleState';

export default function useTaskTitle() {
  const { title, setTitle } = taskState;

  const changeTitle = (newTitle: string) => {
    setTitle(newTitle);
  };

  return {
    title, changeTitle,
  };
}
