import useCounter from '../hooks/useCounter';

export default function Counter() {
  const { count, increase } = useCounter();

  const handleClick = () => {
    increase();
  };

  return (
    <div>
      <h2>This is counter</h2>
      <div>
        <p>{count()}</p>
        <button onClick={handleClick}>+</button>
      </div>
    </div>
  );
}
