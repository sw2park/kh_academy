export function Todo({text}) {
  return <li>{text}</li>;
}

export const DUMMY_TODOS = [
  '리액트 배우기',
  '리액트 연습',
  '개이득!',
  '나는 여기서 나갈래'
];


export default function App() {
  return(
    <div>
      <ul>
        {DUMMY_TODOS.map((dummyItem) => <Todo key={dummyItem} text={dummyItem}/>)}
      </ul>
    </div>
  );
}