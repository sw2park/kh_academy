import { useState, useRef } from "react";

export default function Player() {
  const playerName = useRef(); // 가상DOM(JSX)를 연결하기 위한 Hook
  // const [enteredPlayerName, setEnteredPlayerName] = useState(null);

  function handleClick() {
    // setEnteredPlayerName(playerName.current.value);
    playerName.current.value = '';
  }

  return (
    <section id="player">
      <h2>환영합니다 { playerName.current ? playerName.current.value : "익명"}님</h2>
      <p>
        <input ref={playerName} type="text" />
        <button onClick={handleClick}>확인</button>
      </p>
    </section>
  );
}