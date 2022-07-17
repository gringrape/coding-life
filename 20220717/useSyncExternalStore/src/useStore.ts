import { useSyncExternalStore } from 'react';

import { ExternalStore, STORE_PROPERTY_NAME } from './core';

export default function useStore(store: any) {
  const externalStore : ExternalStore = Reflect.get(store, STORE_PROPERTY_NAME);
  return useSyncExternalStore(
    externalStore.subcribe.bind(externalStore),
    externalStore.getSnapshot.bind(externalStore),
  );
}
