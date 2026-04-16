import "./Dashboard.css";

const Dashboard = () => {
  return (
    <section className="dashboard">
      <div className="dashboard__card">
        <h2 className="dashboard__title">Bienvenido</h2>
        <p className="dashboard__text">
          Este será el panel principal del sistema de inventario.
        </p>
      </div>
    </section>
  );
};

export default Dashboard;