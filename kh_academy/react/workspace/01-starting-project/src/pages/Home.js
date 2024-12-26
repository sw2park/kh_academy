import { Link, useNavigate } from "react-router-dom";

function HomePage() {
    const navigate = useNavigate(); // 라우터에 정의된 주소에 요청을 프로그램적으로 할 수 있게 도와줌
    function navigateHandler(){
        setTimeout(() => {
            navigate("/products");
        }, 3000);
    }
  return (
    <>
      <h1>내 홈페이지</h1>
      <p><Link to="products">여기</Link>로 이동해서 제품 목록을 확인할 수 있습니다.</p>
      <p>
        <button onClick={navigateHandler}>3초 후 페이지 전환</button>
      </p>
    </>
  );
}
export default HomePage;
