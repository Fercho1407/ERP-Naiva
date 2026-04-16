import type { ReactNode } from "react";
import Dashboard from "../pages/Dashboard/Dashboard";
import CrearAlmacen from "../pages/CrearAlmacen/CrearAlmacen";

export interface AppRoute {
  path: string;
  label: string;
  element: ReactNode;
}

export const appRoutes: AppRoute[] = [
  {
    path: "/",
    label: "Dashboard",
    element: <Dashboard />,
  },
  {
    path: "/almacenes/crear",
    label: "Crear almacén",
    element: <CrearAlmacen />,
  },
  {
    path: "/almacenes",
    label: "Almacenes",
    element: <div>Página de almacenes</div>,
  },
  {
    path: "/inventario",
    label: "Inventario",
    element: <div>Página de inventario</div>,
  },
  {
    path: "/movimientos/entradas",
    label: "Entradas",
    element: <div>Página de entradas</div>,
  },
  {
    path: "/movimientos/salidas",
    label: "Salidas",
    element: <div>Página de salidas</div>,
  },
  {
    path: "/movimientos/traspasos",
    label: "Traspasos",
    element: <div>Página de traspasos</div>,
  },
  {
    path: "/productos",
    label: "Productos",
    element: <div>Página de productos</div>,
  },
  {
    path: "/usuarios",
    label: "Usuarios",
    element: <div>Página de usuarios</div>,
  },
];