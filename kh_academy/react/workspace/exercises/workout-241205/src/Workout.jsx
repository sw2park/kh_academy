import { useRef } from "react";

export default function Workout({ title, description, time, onComplete }) {

    const timer = useRef();

  function handleStartWorkout() {
    // Todo: 타이머 시작
    timer = setTimeout(handleStopWorkout, timeout);
  }

  function handleStopWorkout() {
    // Todo: 타이머 멈추기
    clearTimeout(timer.current);
    onComplete();
  }

  return (
    <article className="workout">
      <h3>{title}</h3>
      <p>{description}</p>
      <p>{time}</p>
      <p>
        <button onClick={handleStartWorkout}>시작</button>
        <button onClick={handleStopWorkout}>그만</button>
      </p>
    </article>
  );
}
