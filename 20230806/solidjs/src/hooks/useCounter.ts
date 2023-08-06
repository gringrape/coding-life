import { createSignal } from 'solid-js';

export default function useCounter() {
  const [count, setCount] = createSignal(0);

  const increase = () => {
    setCount((c) => c + 1);
  };

  return {
    count,
    increase,
  };
}
