import { ChangeEvent } from 'react';

import useUserStore from './useUserStore';

export default function App() {
  const userStore = useUserStore();

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { value } = e.target;
    userStore.changeName(value);
  };

  return (
    <>
      <h1>사용자 이름 변경</h1>
      <div>
        <input
          type="text"
          value={userStore.name}
          onChange={handleChange}
        />
      </div>
      <p>{userStore.name}</p>
    </>
  );
}
