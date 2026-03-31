package naiva.com.mx.erp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DireccionResponseDTO {
    private Integer idDireccion;
    private String calle;
    private String numero;
    private String codigoPosta;
    private String estado;
}
