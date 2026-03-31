package naiva.com.mx.erp.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCreateDTO {
    private String nombreProducto;
    private BigDecimal precio;
    private String medida;
    private String unidadMedida;
}
