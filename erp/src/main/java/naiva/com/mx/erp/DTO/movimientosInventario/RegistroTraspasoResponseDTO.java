package naiva.com.mx.erp.DTO.movimientosInventario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegistroTraspasoResponseDTO {
    private Integer stockActualAlmacenOrigen;
    private Integer stockActualAlmacenDestino;
}
