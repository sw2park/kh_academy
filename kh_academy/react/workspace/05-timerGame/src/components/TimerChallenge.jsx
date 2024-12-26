import { useState, useRef } from "react";
import ResultModal from "./ResultModal";

// let timer;

export default function TimerChallenge({ title, targetTime }) {
  const timer = useRef();
  const dialog = useRef();
  const [timerStarted, setTimerStarted] = useState(false);
  const [timerExpired, setTimerExpired] = useState(false);

  function handleStart() {
    timer.current = setTimeout(() => {
      setTimerExpired(true);
      dialog.current.showModal(); // react(x) html의 기본요소
    }, targetTime * 1000);

    setTimerStarted(true);
  }

  function handleStop() {
    clearTimeout(timer.current);
  }

  return (
    <>
      <ResultModal ref={dialog} targetTime={targetTime} result="lost"/>
      <section className="challenge">
        <h2>{title}</h2>
        {timerExpired && <p>패배!!!</p>}
        <p className="challenge-time">{targetTime} 초</p>
        <p>
          <button onClick={timerStarted ? handleStop : handleStart}>
            {timerStarted ? "멈춤" : "시작"}
          </button>
        </p>
        <p className={timerStarted ? "active" : undefined}>
          {timerStarted ? "동작중..." : "비활성"}
        </p>
      </section>
    </>
  );
}