import { useParams, Link } from "react-router-dom";

function EventDetailPage(){
    const params = useParams();

    return (
        <>
        <h1>이벤트 상세 페이지</h1>
        <h2>{params.eventId}</h2>
        <p><Link to=".." relative="path">뒤로 가기</Link></p>
        </>
    );
}

export default EventDetailPage;