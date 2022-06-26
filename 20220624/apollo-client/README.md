# Apollo client
https://www.apollographql.com/docs/react/get-started/

## Apollo client 설치
```bash
npm install @apollo/client graphql
```

## client 생성
```
const client = new ApolloClient({
  uri: 'https://48p1r2roz4.sse.codesandbox.io',
  cache: new InMemoryCache()
});
```

## 간단한 쿼리
```
const GET_GREETING = gql`
  query GetGreeting {
    greeting {
      message
    }
  }
`;
```

## 쿼리 사용
```
import { GET_GREET_MESSAGE } from './queries';

export default function App() {
  const { loading, error, data } = useQuery(GET_GREET_MESSAGE);

  if (loading) {
    return <p>...</p>;
  }

  if (error) {
    return <p>error</p>;
  }

  const { greet } = data;

  return <p>{greet}</p>;
}
```
