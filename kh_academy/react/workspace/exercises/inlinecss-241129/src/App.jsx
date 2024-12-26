import { useState } from "react";

function App() {
  const [stateColor, setStateColor] = useState("white");

  return (
    <div id="app">
      <h1 style={{ color: stateColor }}>위대한 CSS!</h1>
      <menu>
        <li>
          <button
            onClick={() => {
              setStateColor("green");
            }}
          >
            Yes
          </button>{" "}
        </li>
        <li>
          <button
            onClick={() => {
              setStateColor("red");
            }}
          >
            No
          </button>{" "}
        </li>
      </menu>
    </div>
  );
}

export default App;
