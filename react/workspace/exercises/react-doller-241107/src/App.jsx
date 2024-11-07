import { useState } from "react";

//할일 : 버튼을 눌렀을 때 100달러가 75달러로 변경되도록 만들어 보자
export default function App() {
  const [price, setPrice] = useState(100);

  return (
      <div>
          <p data-testid="price">${price}</p>
          <button onClick={()=>setPrice(75)}>Apply Discount</button>
      </div>
  );
}