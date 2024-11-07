export const user = {
  name: '',
};

function App() {
  // 목표: 이 핸들러함수는 <button>이 클릭 되었을 때 값을 전달받아서 user객체의 name 키값을 변경시켜야 한다.(콘솔 출력은 덤)
  function handleCreateUser(name) {
    user.name = name;
    console.log(name);
  }

  return (
    <div id="app">
      <h1>User Login</h1>
      <p>
        <label>Name</label>
        {/* 역시 여기서 입력값 처리는 안해도 된다 */}
        <input type="text" id="name"/>
      </p>

      <p id="actions">
        <button onClick={()=>{handleCreateUser(document.getElementById('name').value)}}>Create User</button>
      </p>
    </div>
  );
}

export default App;