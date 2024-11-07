export default function TabButton({onSelect, children}){
    // console.log("TabButton 컴포넌트가 실행되었습니다.");
    // 일반적으로 JS에서 아래와 같이 이벤트리스너를 하지만 리액트에선 적절한 방식이 아님
    // document.querySelector('button').addEventListener('click', ()=>{})
    return (
        <li><button onClick={onSelect}>{children}</button></li>
    );
};