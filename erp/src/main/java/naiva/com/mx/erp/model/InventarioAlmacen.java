package naiva.com.mx.erp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import naiva.com.mx.erp.model.producto.ProductoVariante;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(InventarioAlmacenId.class)
@Table(name = "inventario_almacen")
public class InventarioAlmacen {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_almacen", columnDefinition = "INT UNSIGNED")
    private Almacen almacen;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_producto_variante", columnDefinition = "INT UNSIGNED")
    private ProductoVariante productoVariante;

    @Column(name = "stock_actual", columnDefinition = "INT UNSIGNED")
    private Integer stockActual;

    @Column(name = "ubicacion_interna")
    private String ubicacionInterna;
}