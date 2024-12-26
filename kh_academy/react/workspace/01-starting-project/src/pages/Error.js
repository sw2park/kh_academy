import MainNavigation from "../components/MainNavigation";

function ErrorPage(){
    return (
        <>
        <MainNavigation />
        <main>
            <h1>에러가 발생하였습니다.</h1>
            <p>요청하신 페이지를 찾을 수 없습니다.</p>
        </main>
        </>
    );
}

export default ErrorPage;