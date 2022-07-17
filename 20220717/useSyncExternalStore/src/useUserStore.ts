import { useSyncExternalStore } from 'react';

import UserStore from './UserStore';

const userStore = new UserStore();

export default function useUserStore() {
  useSyncExternalStore(
    userStore.subcribe.bind(userStore),
    userStore.getSnapshot.bind(userStore),
  );

  return {
    name: userStore.name,
    changeName: userStore.changeName.bind(userStore),
  };
}
