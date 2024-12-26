import { NavLink } from "react-router-dom";
import classes from "./MainNavigation.module.css";

function MainNavigation() {
  return (
    <header className={classes.header}>
      <nav>
        <ul className={classes.list}>
          <li>
            <NavLink
              to="/"
              className={({isActive}) => (isActive ? classes.active : undefined)}
            //   style={({isActive}) => ({textAlign : isActive ? 'center' : 'left'})}
              end
            >
              홈으로
            </NavLink>
          </li>
          <li>
            <NavLink
              to="products"
              className={({isActive}) => (isActive ? classes.active : undefined)}
              end
            >
              제품목록
            </NavLink>
          </li>
        </ul>
      </nav>
    </header>
  );
}

export default MainNavigation;
