//  할일 : 아래 조건에 따라 Input 컴포넌트를 완성하기 
export default function Input({richText, ...props}) {
    // 만약 richText 프랍이 true이면 <textarea>를 이용해서 jsx코드를 완성
    // 아닌 경우는 <input>을 이용해서 jsx코드를 완성
    // 나머지 모든 프랍은 알아서 전달 받아서 jsx코드를 완성
    return (
      <>
        {richText ? <textarea {...props}></textarea> : <input {...props}/>}
      </>
    );
  }