import React from 'react';

function MainGoal(){
  return (
    <div id="app">
      <h1>MainGoal 컴포넌트를 만드는게 목적</h1>
      <p>
        이 컴포넌트는 여러분의 주요 목표를 설정하는 텍스트 단락을 출력하는 것이 목표
      </p>
      <p>
        새로운 컴포넌트를 만들어야 하고, 그 다음 App컴포넌트 안에서 해당 컴포넌트를 출력하는 것이 목적
      </p>
    </div>
  );
}

function App() {
  return (
    <div id="app">
      <h1>Time to Practice!</h1>
      <p>
        Build a <code>&lt;MainGoal&gt;</code> component and insert it below this
        text.
      </p>
      <p>
        Your <code>&lt;MainGoal&gt;</code> component should simply output some
        text that describes your main course goal (e.g., &quot;My main goal:
        Learn React in great detail&quot;).
      </p>
      <p>
        <strong>Important:</strong> You custom component must contain the text
        &quot;My main goal:&quot;
      </p>
      <p>
        <strong>Also important:</strong> For the automatic checks to succeed,
        you <strong>must export</strong> your custom component function! Not as
        a default but simply by adding the <code>export</code> keyword in front
        of your function (e.g., <code>export function YOUR_COMPONENT_NAME</code>
        ).
      </p>
      {/* DON'T CHANGE THE TEXT / CONTENT ABOVE */}
      {/* OUTPUT YOUR COMPONENT HERE */}
      <MainGoal />
    </div>
  );
}

export default App;