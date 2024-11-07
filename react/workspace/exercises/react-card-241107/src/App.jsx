import Card from './Card';

function App() {
  return (
    <div id="app">
      <h1>가용한 전문가 리스트</h1>
      <Card name="앤써니 블레이크">
        <p>
          블레이크는 일리노이 대학의 컴퓨터 공학과 교수입니다.
        </p>
        <p>
          <a href="mailto:blake@example.com">앤써니에게 이메일 보내기</a>
        </p>
      </Card>

      <Card name="마리아 마일즈">
        <p>
          마리아는 일리노이 대학의 컴퓨터 공학과 교수입니다.
        </p>
        <p>
          <a href="mailto:blake@example.com">마리아에게 이메일 보내기</a>
        </p>
      </Card>
    </div>
  );
}

export default App;