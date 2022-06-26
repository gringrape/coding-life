import * as ReactDOM from 'react-dom';

import { ApolloProvider } from '@apollo/client';

import App from './App';

import createClient from './createClient';

const container = document.getElementById('app');
ReactDOM.render(
  <ApolloProvider client={createClient()}>
    <App />
  </ApolloProvider>, container,
);
