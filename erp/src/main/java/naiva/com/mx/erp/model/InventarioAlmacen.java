package naiva.com.mx.erp.model;


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
import naiva.com.mx.erp.model.producto.ProductoVariante;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventario_almacen")
@Data
public class InventarioAlmacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED", name = "id_inventario_almacen")
    private Integer idInventarioAlmacen;

    @ManyToOne
    @JoinColumn(name = "id_almacen", columnDefinition = "INT UNSIGNED")
    private Almacen almacen;

    @ManyToOne
    @JoinColumn(name = "id_producto_variante", columnDefinition = "INT UNSIGNED")
    private ProductoVariante productoVariante;

    @Column(name = "stock_actual", columnDefinition = "INT UNSIGNED")
    private Integer stockActual;

    @Column(name = "ubicacion_interna")
    private String ubicacionInterna;
}