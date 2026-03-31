package naiva.com.mx.erp.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoResponseDTO {
    private String nombreProducto;
    private BigDecimal precio;
}