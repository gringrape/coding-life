import { useSyncExternalStore, useCallback } from 'react';

export default function useStore(store, selector) {
  return useSyncExternalStore(
    store.subscribe,
    useCallback(() => selector(store.getState(), [store, selector])),
  );
}
