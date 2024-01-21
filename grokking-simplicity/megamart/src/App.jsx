import styled from 'styled-components';

const Container = styled.div`
  width: 80%;
  margin: auto;
  border: 2px solid red;
  padding: 20px;
`;

const Header = styled.div`
  border-bottom: 2px solid red;
  padding-bottom: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const CartTotal = styled.div`
  font-size: 1.5em;
  font-weight: bold;
`;

const Product = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 20px;
`;

const ProductImage = styled.img`
  width: 100px; /* Adjust as needed */
`;

const Price = styled.div`
  font-size: 1.2em;
  font-weight: bold;
`;

const BuyButton = styled.button`
  background-color: red;
  color: white;
  padding: 10px 20px;
  border: none;
  cursor: pointer;
`;

export default function App() {
  return (
    <Container>
      <Header>
        <h1>MegaMart</h1>
        <CartTotal>₩75.23</CartTotal>
      </Header>
      <Product>
        <h2>Bread</h2>
        <Price>₩6</Price>
        <BuyButton>Buy Now</BuyButton>
      </Product>
      <Product>
        <h2>T-Shirt</h2>
        <Price>₩2</Price>
        <BuyButton>Buy Now</BuyButton>
      </Product>
    </Container>
  );
}
