# useSyncExternalStore
## useSyncExternalStore API
link: https://reactjs.org/docs/hooks-reference.html#usesyncexternalstore

```typescript
const state = useSyncExternalStore(
  subscribe,
  getSnapshot,
);

```
인자들 설명.

`subscribe`: store가 바뀔때마다 호출되는 콜백을 등록하는 함수.
`getSnapshot`: store의 현재값을 반환하는 함수. 

## 가장 단순한 예제 구현
store에서는 useSyncExternalStore에서 요구하는 것들을 구현해주면 된다. 

- `getSnapshot`에서는 현재 상태를 확인할 수 있도록 현재 상태를 반환한다.
- `subscribe`에서는 상태가 업데이트 될때마다 실행되는 콜백을 등록해준다. (반환으로는 해제 함수)
- `setState`는 상태가 업데이트 되고, 등록된 콜백을 모두 함께 실행시킨다. 

`store`:
```javascript
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
```

`client`:
```javascript
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
```

## UserStore의 활용 중간 단계

## Reflection, Decorator를 활용한 Store 추상화
