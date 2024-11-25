import Input from "./Input";

function App() {
  return (
    <div id="content">
      <Input type="text" placeholder="자기 이름" />
      <Input richText placeholder="자신의 메시지" />
      <input type="checkbox" name="gender" value='female' />여성
      <input type="checkbox" name="gender" value='male' />남성
    </div>
  );
}

export default App;