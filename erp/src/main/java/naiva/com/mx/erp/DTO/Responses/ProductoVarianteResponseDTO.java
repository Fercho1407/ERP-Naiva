package naiva.com.mx.erp.DTO.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductoVarianteResponseDTO {
    private String codigoBarras;
    private String nombreProducto;
    private String descripcionProducto;
    private String NombrematerialTrabajo;
    private String valorMedida;
    private String nombreMarca;
    private String unidadMedidaAbreviatura;
    private String subcategoria;
    private String categoria;
}
