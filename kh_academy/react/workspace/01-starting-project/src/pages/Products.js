import { Link } from "react-router-dom";

const PRODUCT = [
  { id: "p1", title: "제품1번" },
  { id: "p2", title: "제품2번" },
  { id: "p3", title: "제품3번" },
];

function ProductsPage() {
  return (
    <>
      <h1>제품 목록 페이지</h1>
      <ul>
        {PRODUCT.map((prod) => (
          <li key={prod.id}>
            <Link to={`${prod.id}`}>{prod.title}</Link>
          </li>
        ))}
      </ul>
    </>
  );
}

export default ProductsPage;
