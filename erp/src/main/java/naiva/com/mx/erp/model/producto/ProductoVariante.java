package naiva.com.mx.erp.model.producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto_variante")
public class ProductoVariante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_variante", columnDefinition = "INT UNSIGNED")
    private Integer idProductoVariante;
    
    @Column(name = "codigo_barras")
    private String codigoBarras;

    @ManyToOne
    @JoinColumn(name = "id_material_trabajo", columnDefinition="INT UNSIGNED")
    private MaterialTrabajo materialTrabajo;

    @ManyToOne
    @JoinColumn(name = "id_medida", columnDefinition="INT UNSIGNED")
    private Medida medida;

    @ManyToOne
    @JoinColumn(name = "id_unidad_medida", columnDefinition="INT UNSIGNED")
    private UnidadMedida unidadMedida;

    @ManyToOne
    @JoinColumn(name = "id_marca", columnDefinition="INT UNSIGNED")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_producto", columnDefinition="INT UNSIGNED")
    private Producto producto;
}
