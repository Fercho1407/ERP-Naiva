package naiva.com.mx.erp.DTO.movimientosInventario;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * Clase con la informacion necesaria para poder traspasar un producto de un almacen a otro
 */
@AllArgsConstructor
@Getter
@Setter
//Debe usarse la anotacion @valid en el controlador, para que se hagan validas las anotaciones
public class RegistroTraspasoDTO {
    @NotNull
    @Min(1)
    private Integer idAlmacenOrigen;

    @NotNull
    @Min(1)
    private Integer idAlmacenDestino;

    @NotNull
    @Min(1)
    private Integer idProductoInventarioAlmacen;

    @NotNull
    @Min(1)
    private Integer stockTraspaso;

    private String nuevaUbicacionInterna;

    @NotBlank(message = "Debe haber un responsable del movimiento")
    private String autotizacion;

    //En caso de que el transporte haya generado un gasto se debe registrar
    @NotNull
    private BigDecimal costoTranslado;
}
