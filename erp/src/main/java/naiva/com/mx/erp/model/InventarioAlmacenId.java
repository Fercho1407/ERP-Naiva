package naiva.com.mx.erp.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioAlmacenId implements Serializable {
    private Integer almacen;
    private Integer productoVariante;
}
