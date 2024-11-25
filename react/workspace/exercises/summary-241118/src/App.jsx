// import { useState, Fragment } from "react";

function Summary({ text }) {
  return (
    <>
      <h1>요약</h1>
      <p>{text}</p>
    </>
  //   <Fragment>
  //   <h1>요약</h1>
  //   <p>{text}</p>
  // </Fragment>
  );
}

function App() {
  return (
    <div id="app" data-testid="app">
      <Summary text="fragment는 불필요한 HTML 요소 사용을 줄여줍니다.." />
    </div>
  );
}

export default App;