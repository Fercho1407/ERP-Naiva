package naiva.com.mx.erp.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED ", name = "id_producto")
    private Integer idPoducto;

    private String nombre;

    @Column(precision = 9, scale = 2)
    private BigDecimal precio;

    @Column(columnDefinition = "NOT NULL")
    private String valorMedida;

    @ManyToOne
    @JoinColumn(name = "id_medida", columnDefinition = "INT UNSIGNED")
    private Medida medida;
}
