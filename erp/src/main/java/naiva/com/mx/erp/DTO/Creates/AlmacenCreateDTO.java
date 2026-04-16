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
    private String numeroExterior;
    private String codigoPostal;
    private String localidad;
    private String colonia;
    private String nombreEstado;
}
