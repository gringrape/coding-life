import UserStore from './UserStore';

import useStore from './useStore';

const userStore = new UserStore();

export default function useUserStore() {
  useStore(userStore);
  return {
    name: userStore.name,
    changeName: userStore.changeName.bind(userStore),
  };
}
