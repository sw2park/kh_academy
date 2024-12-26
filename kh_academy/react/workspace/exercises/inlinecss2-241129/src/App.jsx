import { useState } from "react";

function App() {
  const [choice, setChoice] = useState('highlight');

  return (
    <div id="app">
      <h1 className={`${choice}`}>위대한 CSS!</h1>
      <menu>
        <li>
          <button onClick={() => setChoice('yes')}>Yes</button>
        </li>
        <li>
          <button onClick={() => setChoice('no')}>No</button>
        </li>
      </menu>
    </div>
  );
}

export default App;
