import {
  ApolloClient,
  InMemoryCache,
} from '@apollo/client';

export default function createClient() {
  return new ApolloClient({
    uri: 'https://localhost:4000',
    cache: new InMemoryCache(),
  });
}
