import UserStore from './UserStore';

describe('UserStore', () => {
  test('changeName', () => {
    const name = 'Peter Parker';

    const userStore = new UserStore();

    userStore.changeName(name);

    expect(userStore.name.value).toBe(name);
  });
});
