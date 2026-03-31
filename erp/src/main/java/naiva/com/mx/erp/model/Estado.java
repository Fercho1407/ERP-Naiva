package naiva.com.mx.erp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Configura la clave primaria para que sea autoincrement
    @Column(columnDefinition = "TINYINT UNSIGNED")
    private Integer id_estado;

    private String estado;
}
