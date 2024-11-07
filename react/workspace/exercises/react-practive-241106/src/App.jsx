import React from "react";

export const userData = {
  firstName: "성우", // 이름은 자유롭게 변환
  lastName: "박", // 이름은 자유롭게 변환
  title: "학생", // 이름은 자유롭게 변환
};

// User 컴포넌트 코드를 수정해서 userData를 출력할 수 있도록 작성
export function User() {
  return (
    <div id="user" data-testid="user">
      <h2>
      {userData.lastName}{userData.firstName}
      </h2>
      <p>{userData.title}</p>
    </div>
  );
}

// App컴포넌트 코드는 수정하지 맙시다
function App() {
  return (
    <div id="app">
      <h1>연습문제2</h1>
      <p>리액트를 이용해서 동적으로 코드를 출력해봅시다. 💪</p>
      <User />
    </div>
  );
}

export default App;