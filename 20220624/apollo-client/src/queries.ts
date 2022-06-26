import { gql } from '@apollo/client';

export const GET_GREET_MESSAGE = gql`
  query GetGreetMessage {
    greet
  }
`;

// TODO: delete this
export default {};
