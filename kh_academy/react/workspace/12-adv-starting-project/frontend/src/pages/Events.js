import { Link } from "react-router-dom";

const EVENTS = [
  { id: "출석 이벤트", title: "출석 이벤트" },
  { id: "리액트 이벤트", title: "리액트 이벤트" },
  { id: "라우터 이벤트", title: "라우터 이벤트" },
];

function EventsPage() {
  return (
    <>
      <h1>이벤트 페이지</h1>
      <ul>
        {EVENTS.map((eve) => (
          <li key={eve.id}>
            <Link to={`${eve.id}`}>{eve.title}</Link>
          </li>
        ))}
        <p><Link to=".." relative="path">뒤로 가기</Link></p>
      </ul>
    </>
  );
}

export default EventsPage;
