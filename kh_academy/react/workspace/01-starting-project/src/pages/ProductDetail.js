import { useParams, Link } from "react-router-dom";

function ProductDetailPage() {
  const params = useParams(); // :productId로 전달된 애들을 가져옴

  return (
    <>
      <h1>제품 상세 페이지</h1>
      <p>{params.productsId}</p>
      <p><Link to=".." relative="path">뒤로</Link></p>
    </>
  );
}
export default ProductDetailPage;