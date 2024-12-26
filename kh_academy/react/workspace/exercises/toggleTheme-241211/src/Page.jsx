import Header from "./Header";
import { ThemeContext } from "./ThemeContextProvider";
import { useContext } from "react";

export default function Page() {
  const { theme } = useContext(ThemeContext);
  return (
    <div id="app" className={theme}>
      <Header />
      <article>
        <h2>리액트 강의</h2>
        <p>리액트를 처음부터 깊이있게!</p>
      </article>
    </div>
  );
}
