import componentsImg from "./assets/components.png";
import jsxImg from "./assets/jsx-ui.png";
import stateImg from "./assets/state-mgmt.png";
import propsImg from "./assets/config.png";

const CORE_COMCEPTS = [
    {title:"컴포넌트", description:"UI를 구성하는 핵심 블럭", img:componentsImg},
    {title:"JSX", description:"HTML코드의 형태를 취하고 있는 실제로 렌더링 되어야 하는 return 구문", img:jsxImg},
    {title:"Props", description:"데이터를 전달해서 컴포넌트를 유연하게 만들어주는 입력값", img:propsImg},
    {title:"State", description:"컴포넌트 렌더링을 유발시키며, 리액트에 의해서 관리되는 UI에 관련된 저장용 데이터", img:stateImg}
];

export default CORE_COMCEPTS;