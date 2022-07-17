import createStore from './createStore';

import useStore from './useStore';

const store = createStore({ count: 0 });

export default function useCounter() {
  const count = useStore(store, (state) => state.count);
  return {
    count,
    increase() {
      store.setState((previousState) => ({
        ...previousState,
        count: previousState.count + 1,
      }));
    },
  };
}
