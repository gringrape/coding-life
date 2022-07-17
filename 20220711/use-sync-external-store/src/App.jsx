import useCounter from './useCounter';

export default function App() {
  const { count, increase } = useCounter();

  return (
    <div>
      <h1>Counter</h1>
      <div>
        <p>{count}</p>
        <button type="button" onClick={increase}>
          +
        </button>
      </div>
    </div>
  );
}
