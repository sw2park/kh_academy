export default function Button({ mode = "filled", className, Icon, children, ...props }) {
  // Todo: 이 컴포넌트를 완성하자
  // !!! 중요:
  // 목표 모양을 완성하기 위해서 <span className="button-icon"> 로 아이콘을 감싸주자
  // children 프랍 역시 <span>로 감싸준다

  let cssClasses = `button ${mode}-button`;
  if (Icon) {
    cssClasses += " icon-button";
  }

  if(className){
    cssClasses += ' ' + className;
  }

  return (
    <button className={cssClasses} {...props}>
      {Icon && (
        <span className="button-icon">
          <Icon />
        </span>
      )}
      {children}
    </button>
  );
}
