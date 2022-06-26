import { render } from '@testing-library/react';

import { MockedProvider } from '@apollo/client/testing';

import App from './App';

import { GET_GREET_MESSAGE } from './queries';

describe('App', () => {
  const mocks = [
    {
      request: {
        query: GET_GREET_MESSAGE,
      },
      result: {
        data: {
          greet: '안녕하세요',
        },
      },
    },
  ];

  it('renders greeting message', () => {
    const { container } = render(
      <MockedProvider mocks={mocks} addTypename={false}>
        <App />
      </MockedProvider>,
    );

    expect(container).toHaveTextContent('안녕하세요');
  });
});
