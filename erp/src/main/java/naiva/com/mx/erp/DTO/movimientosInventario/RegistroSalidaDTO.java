package naiva.com.mx.erp.DTO.movimientosInventario;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RegistroSalidaDTO {
    @NotNull
    @Min(1)
    private Integer idProductoInventarioAlmacen;

    @NotNull
    @Min(1)
    private Integer stockSalida;
    
    @NotBlank(message = "ALguien debe autorizar esta salida")
    private String autorizacion;

    @NotNull
    private BigDecimal costoUnitarioVenta;

    private String observaciones;
}
