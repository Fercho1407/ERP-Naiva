import { createBrowserRouter } from "react-router-dom";
import Layout from "../components/Layout/Layout";
import { appRoutes } from "../routes/appRoutes";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: appRoutes.map((route) => ({
      path: route.path === "/" ? "" : route.path.slice(1),
      element: route.element,
    })),
  },
]);