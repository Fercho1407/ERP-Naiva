package naiva.com.mx.erp.model;

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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED AUTO_INCREMENT")
    private Integer id_direccion;

    private String calle;
    private String numero_exterior;
    private String codigo_postal;
    private String localidad;
    private String colonia;

    @ManyToOne
    @JoinColumn(name = "id_estado", columnDefinition = "TINYINT UNSIGNED")
    private Estado estado;

}
