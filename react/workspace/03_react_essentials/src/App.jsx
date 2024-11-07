import { useState } from "react";

import { CORE_CONCEPTS, EXAMPLES } from "./data.js";
import Header from "./components/Header/Header.jsx";
import CoreConcept from "./components/CoreConcept.jsx";
import TabButton from "./components/TabButton.jsx";

function App() {
  const [selectedTopic, setSelectedTopic] = useState(); // [저장공간, 저장공간용setter함수]
  // 구조분해, 디스트럭쳐를 안했을 시 위 코드는 아래와 같음
  // const stateArray = userState("버튼을 클릭하세요.");
  // const setSelectedTopic = stateArray[1];

  // let tabContent = '버튼을 클릭하세요';

  function handleSelect(selectedButton) {
    // selectedButton => 'Components', 'jsx', 'props', 'stats'
    // console.log(`현재 선택된 탭은 ${selectedButton} 탭 입니다.`);
    // tabContent = selectedButton;
    setSelectedTopic(selectedButton);
    console.log(selectedTopic);
  }

  // console.log('App 컴포넌트가 실행되었습니다.');

  let tabContent = <p>주제를 선택 합시다.</p>;
  if(selectedTopic){
    tabContent = (
      <div id="tab-content">
        <h3>{EXAMPLES[selectedTopic].title}</h3>
        <p>{EXAMPLES[selectedTopic].description}</p>
        <pre>
          <code>{EXAMPLES[selectedTopic].code}</code>
        </pre>
      </div>
    );
  }

  return (
    <div>
      <Header />
      <main>
        <section id="core-concepts">
          <h2>핵심 개념</h2>
          <ul>
            <CoreConcept {...CORE_CONCEPTS[0]} />
            <CoreConcept {...CORE_CONCEPTS[1]} />
            <CoreConcept {...CORE_CONCEPTS[2]} />
            <CoreConcept {...CORE_CONCEPTS[3]} />
          </ul>
        </section>
        <section id="examples">
          <h2>예시</h2>
          <menu>
            <TabButton
              onSelect={() => {
                handleSelect("components");
              }}
            >
              컴포넌트
            </TabButton>
            <TabButton
              onSelect={() => {
                handleSelect("jsx");
              }}
            >
              JSX
            </TabButton>
            <TabButton
              onSelect={() => {
                handleSelect("props");
              }}
            >
              PROPS
            </TabButton>
            <TabButton
              onSelect={() => {
                handleSelect("state");
              }}
            >
              STATE
            </TabButton>
          </menu>
          {tabContent}
        </section>
      </main>
    </div>
  );
}

export default App;
