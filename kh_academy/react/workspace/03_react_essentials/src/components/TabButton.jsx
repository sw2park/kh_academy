export default function TabButton({children, isSelected, ...props }) {
  // console.log("TabButton 컴포넌트가 실행되었습니다.");
  return (
    <li>
      <button className={isSelected ? "active" : undefined} {...props}>
        {children}
      </button>
    </li>
  );
}
