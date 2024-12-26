import Toast from './Toast';

function App() {
  function handleEnrol() {
    // 할일 : Toast컴포넌트 보이기
    <Toast/>

    setTimeout(() => {
      // 할일 : Toast컴포넌트 숨기기
    }, 3000);
  }

  return (
    <div id="app">
      {/* 할일 : 여기에 Toast 컴포넌트를 조건에 따라 출력 */}
      <article>
        <h2>React Course</h2>
        <p>
          리액트를 처음부터 끝까지 깊이있게! 고향의 맛!
        </p>
        <button onClick={handleEnrol}>Enrol</button>
      </article> 
    </div>
  );
}

export default App; 