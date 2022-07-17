import { useSyncExternalStore } from 'react';

const store = {
  state: { count: 0 },
  listeners: new Set(),
  getSnapshot() {
    return this.state;
  },
  subcribe(callback: any) {
    this.listeners.add(callback);
    return () => this.listeners.delete(callback);
  },
  setState(reducer) {
    this.state = {
      ...this.state,
      ...reducer(this.state),
    };
    this.listeners.forEach((f) => f());
  },
};

export default function App() {
  const { count } = useSyncExternalStore(
    store.subcribe.bind(store),
    store.getSnapshot.bind(store),
  );

  const handleClick = () => {
    store.setState((state) => ({
      ...state,
      count: count + 1,
    }));
  };

  return (
    <>
      <h1>hello, world</h1>
      <p>{count}</p>
      <button type="button" onClick={handleClick}>+</button>
    </>
  );
}
