import { useState } from "react";

export function Review({ feedback, student }) {
  return (
    <figure>
      <blockquote>
        <p>{feedback}</p>
      </blockquote>
      <figcaption>{student}</figcaption>
    </figure>
  );
}

function App() {
  const [content, setContent] = useState('');
  const [name, setName] = useState('');

  function handleChange(event){
    setContent(event.target.value);
  }

  function nameChange(event){
    setName(event.target.value);
  }

  return (
    <>
      <section id="feedback">
        <h2> 피드백을 공유해주세요</h2>
        <p>
          <label>피드백</label>
          <textarea onChange={handleChange}/>
        </p>
        <p>
          <label>이름</label>
          <input type="text" onChange={nameChange}/>
        </p>
      </section>
      <section id="draft">
        <h2>당신의 피드백</h2>

        <Review feedback={content} student={name}/>

        <p>
          <button>저장</button>
        </p>
      </section>
    </>
  );
}

export default App;