package naiva.com.mx.erp.DTO.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventarioAlmacenResponseDTO {
    private Integer idInventarioAlmacen;
    private String codigoBarras;
    private String productoNombre;
    private String subcategoria;
    private String medida;
    private String unidadMedida;
    private String marca;
    private Integer stock;
    private String ubicacionInterna;
}
