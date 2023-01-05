import { Link } from 'react-router-dom';
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  h1 {
    font-size: 3em;
  }

  img {
    margin-block: 1.5em;
    width: 14em;
    border: 0.8em solid lightgray;
    border-radius: 50%;
  }
`;

const Time = styled.dl`
  font-size: 2em;
  display: flex;
  
  dt, dd {
    margin-block: 1em;
    margin-inline: 0;
  }

  dd {
    color: red;
  }
`;

const MyLink = styled(Link)`
  font-size: 2em;
  padding-block: 1em;
  padding-inline: 2em;
  cursor: pointer;
`;

export default function App() {
  return (
    <Container>
      <h1>알고리즘 풀어서 겨울나기</h1>
      <Time>
        <dt>남은시간:</dt>
        <dd>03:48</dd>
      </Time>
      <img alt="상품이미지" src="http://img1.tmon.kr/cdn4/deals/2021/10/15/8799417126/8799417126_front_8049b43066.jpg" />
      <MyLink to="/problem">
        문제풀이 시작하기
      </MyLink>
    </Container>
  );
}
