import './App.css'

// 목표는 email, password와 loggedIn 값이 App 컴포넌트의 버튼이 눌리면 바뀌도록 만드는 것이다
// 바뀌어야 하는 값은 여러분 맘대로(단, loggedIn 값은 true로 변경이 되어야 한다)
// <input />필드에 입력된 값을 가져올 필요는 없다(나중에 리액트만의 방식으로 가져오는 방법을 익힐 것임)

export const user = {
  email: '',
  password: '',
  loggedIn: false,
};

// 중요: 로그인이 실제로 이루어지는 코드는 아님
// 이 문제는 단순히 이벤트 핸들링에 대한 문제이므로 다른것은 신경쓰지 말 것

function App() {
  function handleLogin(){
    user.email = '버튼을'
    user.password = '눌렀습니다.'
    user.loggedIn = true;
    console.log(user.email);
    console.log(user.password);
    console.log(user.loggedIn);
  }
  return (
    <div id="app">
      <h1>로그인</h1>
      <p>
        <label>이메일</label>
        {/* 여기서 입력된 내용은 신경 쓰지 말 것 */}
        <input type="email" />
      </p>

      <p>
        <label>Password</label>
        {/* 여기서 입력 되는 내용 역시 신경 쓰지 말 것 */}
        <input type="password" />
      </p>

      <p id="actions">
        <button onClick={handleLogin}>Login</button>
      </p>
    </div>
  );
}

export default App;