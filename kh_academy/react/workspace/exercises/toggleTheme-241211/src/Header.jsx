import { useContext } from "react";
import { ThemeContext } from "./ThemeContextProvider";

export default function Header() {
  const {toggleTheme} = useContext(ThemeContext);
  return (
    <header>
      <h1>데모 웹사이트</h1>
      <button onClick={toggleTheme}>테마 토글하기</button>
    </header>
  );
}
