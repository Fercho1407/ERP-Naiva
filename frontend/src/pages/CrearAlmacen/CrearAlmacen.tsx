import { useState } from "react";
import InputField from "../../components/InputField/InputField";
import type { CrearAlmacen } from "../../types/Almacen";
import "./CrearAlmacen.css";

const CrearAlmacen = () => {
  const [form, setForm] = useState<CrearAlmacen>({
    nombreAlmacen: "",
    calle: "",
    numeroExterior: "",
    codigoPostal: "",
    localidad: "",
    colonia: "",
    nombreEstado: "",
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    setForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    console.log("Almacén a guardar:", form);

    // Aquí después conectas tu backend
    // ejemplo:
    // await axios.post("/api/almacenes", form);
  };

  return (
    <section className="crear-almacen">
      <div className="crear-almacen__header">
        <h2 className="crear-almacen__title">Registrar almacén</h2>
        <p className="crear-almacen__subtitle">
          Completa la información general del nuevo almacén.
        </p>
      </div>

      <form className="crear-almacen__form" onSubmit={handleSubmit}>
        <div className="crear-almacen__grid">
          <InputField
            label="Nombre del almacén"
            name="nombreAlmacen"
            value={form.nombreAlmacen}
            onChange={handleChange}
            placeholder="Ej. Almacén Central"
            required
          />

          <InputField
            label="Calle"
            name="calle"
            value={form.calle}
            onChange={handleChange}
            placeholder="Ej. Avenida Principal"
            required
          />

          <InputField
            label="Número exterior"
            name="numeroExterior"
            value={form.numeroExterior}
            onChange={handleChange}
            placeholder="Ej. 125"
            required
          />

          <InputField
            label="Código postal"
            name="codigoPostal"
            value={form.codigoPostal}
            onChange={handleChange}
            placeholder="Ej. 57000"
            required
          />

          <InputField
            label="Localidad"
            name="localidad"
            value={form.localidad}
            onChange={handleChange}
            placeholder="Ej. Nezahualcóyotl"
            required
          />

          <InputField
            label="Colonia"
            name="colonia"
            value={form.colonia}
            onChange={handleChange}
            placeholder="Ej. Benito Juárez"
            required
          />

          <InputField
            label="Estado"
            name="nombreEstado"
            value={form.nombreEstado}
            onChange={handleChange}
            placeholder="Ej. Estado de México"
            required
          />
        </div>

        <div className="crear-almacen__actions">
          <button type="submit" className="crear-almacen__button">
            Guardar almacén
          </button>
        </div>
      </form>
    </section>
  );
};

export default CrearAlmacen;