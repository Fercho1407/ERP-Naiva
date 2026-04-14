package naiva.com.mx.erp.model;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import naiva.com.mx.erp.model.ENUM.Tipomovimiento;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(columnDefinition = "INT UNSIGNED", name = "movimiento_inventario")
    private Integer idMovimientoInventario;

    private String autorizacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento")
    private Tipomovimiento tipomovimiento;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "costo_unitario", precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "fecha", updatable = false)
    private Instant fechaMovimiento;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name="id_inventario_almacen", columnDefinition="INT UNSIGNED")
    private InventarioAlmacen inventarioAlmacen;
}
