import { createSignal, onCleanup } from 'solid-js';

export default function AutoCounter() {
  const [count, setCount] = createSignal(0);

  const interval = setInterval(() => {
    setCount((c) => c + 1);
  }, 1000);

  onCleanup(() => {
    clearInterval(interval);
  });

  return (
    <div>
      <h2>This is auto counter</h2>
      <div>
        <div>
          {count()}
        </div>
      </div>
    </div>
  );
}
