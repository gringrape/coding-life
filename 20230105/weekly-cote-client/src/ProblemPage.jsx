import { useState } from 'react';
import styled from 'styled-components';

const Container = styled.div`
  display: grid;
  padding: 1em;
  grid-template-areas: 
    "a b"
    "a c";
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 4fr 1fr;
  gap: 1em;
  height: 100vh;
  background: gray;

  section {
    border: 1px solid gray;
    border-radius: 8px;
    background: #fff;
  }
`;

const Explanation = styled.section`
  grid-area: a;
  padding: 1em;
`;
const Code = styled.section`
  grid-area: b;
  padding: 1em;

  textarea {
    width: 100%;
    height: 100%;
  }
`;
const Submit = styled.section`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 2em;
  grid-area: c;

  button {
    font-size: 1.5em;
    padding-block: 1em;
    padding-inline: 4em;
  }
`;

export default function ProblemPage() {
  const [code, setCode] = useState(
    `
  class Solution {
    public int[] runningSum() {
      
    }
  }
    `,
  );

  const handleChange = (e) => {
    const { value } = e.target;
    setCode(value);
  };

  return (
    <Container>
      <Explanation>
        <h1>Running Sum of 1d Array</h1>
        <p>
          Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

          Return the running sum of nums.
        </p>
      </Explanation>
      <Code>
        <textarea value={code} onChange={handleChange} />
      </Code>
      <Submit>
        <button type="button">
          제출하기
        </button>
      </Submit>
    </Container>
  );
}
