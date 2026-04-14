package naiva.com.mx.erp.DTO.movimientosInventario;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegistroSalidaResponseDTO {
    private Integer stockActualizado;
    private BigDecimal precioVenta;
}
