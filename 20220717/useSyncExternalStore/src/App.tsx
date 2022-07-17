import { ChangeEvent } from 'react';

import useUserStore from './useUserStore';

export default function App() {
  const { name, changeName } = useUserStore();

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { value } = e.target;
    changeName(value);
  };

  return (
    <>
      <h1>사용자 이름 변경</h1>
      <div>
        <input
          type="text"
          value={name}
          onChange={handleChange}
        />
      </div>
      <p>{name}</p>
    </>
  );
}
