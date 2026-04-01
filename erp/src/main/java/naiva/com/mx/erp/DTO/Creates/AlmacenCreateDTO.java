package naiva.com.mx.erp.DTO.Creates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenCreateDTO {
    private String nombreAlmacen;
    private String calle;
    private String numero_exterior;
    private String codigo_postal;
    private String localidad;
    private String colonia;
    private String nombre_estado;
}
