import { NavLink } from "react-router-dom";

function MainNavigation() {
    return (
        <>
        <header>
            <nav>
                <ul>
                    <li>
                        <NavLink to="/" end>홈으로</NavLink>
                    </li>
                    <li>
                        <NavLink to="events" end>이벤트 목록</NavLink>
                    </li>
                </ul>
            </nav>
        </header>
        </>
    );
};

export default MainNavigation;