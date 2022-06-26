import { useQuery } from '@apollo/client';

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
