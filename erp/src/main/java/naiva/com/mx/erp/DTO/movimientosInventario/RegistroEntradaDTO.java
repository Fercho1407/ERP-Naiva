package naiva.com.mx.erp.DTO.movimientosInventario;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroEntradaDTO {
    Integer idInventarioAlmacen;
    Integer cantidad;
    BigDecimal costoUnitario;
    String autorizacion;
    String observaciones;
}
