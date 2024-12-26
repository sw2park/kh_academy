import { useRef } from "react";

function App() {
  const fp = useRef();

  return (
    <div id="app">
      <p>이미지를 선택해주세요</p>
      <p>
        <input ref={fp} data-testid="file-picker" type="file" accept="image/*" />
        <button onClick={fp.current.click}>이미지 선택</button>
      </p>
    </div>
  );
}

export default App;