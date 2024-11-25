import componentsImg from "./assets/components.png";
import jsxImg from "./assets/jsx-ui.png";
import stateImg from "./assets/state-mgmt.png";
import propsImg from "./assets/config.png";

export const CORE_CONCEPTS = [
  {
    title: "컴포넌트",
    description: "UI를 구성하는 핵심 블럭",
    image: componentsImg,
  },
  {
    title: "JSX",
    description:
      "HTML코드의 형태를 취하고 있는 실제로 렌더링 되어야 하는 return 구문",
    image: jsxImg,
  },
  {
    title: "Props",
    description: "데이터를 전달해서 컴포넌트를 유연하게 만들어주는 입력값",
    image: propsImg,
  },
  {
    title: "State",
    description:
      "컴포넌트 렌더링을 유발시키며, 리액트에 의해서 관리되는 UI에 관련된 저장용 데이터",
    image: stateImg,
  },
];

export const EXAMPLES = {
  components: {
    title: "컴포넌트",
    description:
      "Components are the building blocks of React applications. A component is a self-contained module (HTML + optional CSS + JS) that renders some output.",
    code: `
function Welcome() {
  return <h1>Hello, World!</h1>;
}`,
  },
  jsx: {
    title: "JSX",
    description:
      "JSX is a syntax extension to JavaScript. It is similar to a template language, but it has full power of JavaScript (e.g., it may output dynamic content).",
    code: `
<div>
  <h1>Welcome {userName}</h1>
  <p>Time to learn React!</p>
</div>`,
  },
  props: {
    title: "Props",
    description:
      "Components accept arbitrary inputs called props. They are like function arguments.",
    code: `
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}`,
  },
  state: {
    title: "State",
    description:
      "State allows React components to change their output over time in response to user actions, network responses, and anything else.",
    code: `
function Counter() {
  const [isVisible, setIsVisible] = useState(false);

  function handleClick() {
    setIsVisible(true);
  }

  return (
    <div>
      <button onClick={handleClick}>Show Details</button>
      {isVisible && <p>Amazing details!</p>}
    </div>
  );
}`,
  },
};
