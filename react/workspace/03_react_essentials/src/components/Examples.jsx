import { useState } from "react";
import TabButton from "./TabButton";
import { EXAMPLES } from "../data";
import Section from "./Section";
import Tabs from "./Tabs";

export default function Examples() {
  const [selectedTopic, setSelectedTopic] = useState(); // [저장공간,저장공간용Setter함수]

  function handleSelect(selectedButton) {
    setSelectedTopic(selectedButton);
    console.log(selectedTopic);
  }
  let tabContent = <p>주제를 선택 합시다.</p>;
  if (selectedTopic) {
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
    <Section title={"예시"} id="examples">
      <Tabs
        buttons={
          <>
            <TabButton
              onClick={() => {
                handleSelect("components");
              }}
              isSelected={selectedTopic === "components"}
            >
              컴포넌트
            </TabButton>
            <TabButton
              onClick={() => {
                handleSelect("jsx");
              }}
              isSelected={selectedTopic === "jsx"}
            >
              JSX
            </TabButton>
            <TabButton
              onClick={() => {
                handleSelect("props");
              }}
              isSelected={selectedTopic === "props"}
            >
              Props
            </TabButton>
            <TabButton
              onClick={() => {
                handleSelect("state");
              }}
              isSelected={selectedTopic === "state"}
            >
              State
            </TabButton>
          </>
        }
      >
        {tabContent}
      </Tabs>
    </Section>
  );
}
