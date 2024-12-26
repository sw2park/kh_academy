import Button from './Button';
import HomeIcon from './HomeIcon';
import PlusIcon from './PlusIcon';

function App() {
  return (
     <div id="app">
      <section>
        <h2>채워진버튼 (Default)</h2>
        <p>
          <Button>기본값</Button>
        </p>
        <p>
          <Button mode="x">채워짐(기본값)</Button>
        </p>
      </section>
      <section>
        <h2>외곽선 버튼</h2>
        <p>
          <Button mode="outline">외곽선</Button>
        </p>
      </section>
      <section>
        <h2>텍스트전용 버튼</h2>
        <p>
          <Button mode="text">텍스트</Button>
        </p>
      </section>
      <section>
        <h2>아이콘 있는 버튼</h2>
        <p>
          <Button Icon={HomeIcon}>홈</Button>
        </p>
        <p>
          <Button Icon={PlusIcon} mode="text">
            추가
          </Button>
        </p>
      </section>
      <section>
        <h2>버튼들은 Props를 이용할 수 있어야 한다</h2>
        <p>
          <Button mode="filled" disabled>
            비활성화된 버튼
          </Button>
        </p>
        <p>
          {/* <Button onClick={() => console.log('Clicked!')}>클릭하세요</Button> */}
          <Button onClick={() => alert('클릭됨!')}>클릭하세요</Button>
        </p>
      </section>
    </div>
  );
}

export default App;