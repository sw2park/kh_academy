//처음 실행하면 삭제버튼만 보임
//삭제 버튼을 누르면 삭제 버튼은 숨겨지고 alert 아이디를 가진 div영역만 보임
//진행 버튼을 누르면 처음으로
// App컴포넌트는 손대지 말기
import { useState } from "react";

export default function App() {
  const [isDeleting, setIsDeleting] = useState(false);

  let warning; // 출력할 jsx 코드를 저장하는 목적

  if (isDeleting) {
    warning = (
      <div data-testid="alert" id="alert">
        <h2>진짜?</h2>
        <p>삭제된 내용은 복구 안됌!</p>
        <button onClick={() => setIsDeleting(false)}>진행</button>
      </div>
    );
  } else {
    warning = <button onClick={() => setIsDeleting(true)}>삭제</button>;
  }

  return <div>{warning}</div>;
}