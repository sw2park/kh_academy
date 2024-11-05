import reactImg from './assets/react-core-concepts.png'

const reactDescriptions = ['핵심', '근간이 되는', '중요한'];

function genRandomInt(max){
  return Math.floor(Math.random() * (max+1));
}

function Header() {
  const description = reactDescriptions[genRandomInt(2)];
  return (
    <header>
      <img src={reactImg} alt="Stylized atom" />
      <h1>리액트 필수 요소들</h1>
      <p>우리가 작성하게 될 리액트의 주요 구성 {description} 요소들</p>
    </header>
  );
}

function App() {
  return (
    <div>
      <Header/>
      <main>
        <h2>시작해봅시다!</h2>
      </main>
    </div>
  );
}

export default App;