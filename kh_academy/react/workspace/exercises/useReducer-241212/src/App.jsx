import { useReducer } from "react";

export function counterReducer(state, action) {
  if (action.type === "INCREMENT") {
    return { count: state.count + 1 }
  }
  if (action.type === "DECREMENT") {
    return { count: state.count - 1 }
  }
  if (action.type === "RESET") {
    return { count: 0 }
  }

  return state;
}

function App() {
  const [counterState, dispatchCounterAction] = useReducer(counterReducer, {
    counter: 0,
  });

  return (
    <div id="app">
      <h1>(최종??) 카운터</h1>
      <p id="actions">
        <button onClick={()=>dispatchCounterAction({ type: "INCREMENT" })}>
          증가
        </button>
        <button onClick={()=>dispatchCounterAction({ type: "DECREMENT" })}>
          감소
        </button>
        <button onClick={()=>dispatchCounterAction({ type: "RESET" })}>
          초기화
        </button>
      </p>
      <p id="counter">{counterState.counter}</p>
    </div>
  );
}

export default App;
