import { useState } from "react";
import { NavLink } from "react-router-dom";
import { appRoutes } from "../../routes/appRoutes";
import "./Sidebar.css";

const Sidebar = () => {
  const [collapsed, setCollapsed] = useState(false);

  return (
    <aside className={`sidebar ${collapsed ? "sidebar--collapsed" : ""}`}>
      <div className="sidebar__header">
        {!collapsed && <h1 className="sidebar__title">ERP Inventario</h1>}

        <button
          type="button"
          className="sidebar__toggle"
          onClick={() => setCollapsed((prev) => !prev)}
        >
          {collapsed ? "→" : "←"}
        </button>
      </div>

      <nav className="sidebar__nav">
        {appRoutes.map((route) => (
          <NavLink
            key={route.path}
            to={route.path}
            className={({ isActive }) =>
              `sidebar__link ${isActive ? "sidebar__link--active" : ""}`
            }
            title={route.label}
          >
            <span className="sidebar__link-text">
              {collapsed ? route.label.charAt(0) : route.label}
            </span>
          </NavLink>
        ))}
      </nav>
    </aside>
  );
};

export default Sidebar;