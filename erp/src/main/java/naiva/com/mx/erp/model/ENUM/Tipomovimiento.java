package naiva.com.mx.erp.model.ENUM;

import lombok.Getter;

@Getter
public enum Tipomovimiento {
    ENTRADA("entrada a almacen"),
    SALIDA("Salida del almacen"),
    AJUSTE("Ajuste de stock"),
    TRASPASO_ENTRADA("Llegada de otro almacen"),
    TRASPASO_SALIDA("Salida hacia otro almacen");

    private final String tipoMovimiento;

    Tipomovimiento(String tipoMovimiento){
        this.tipoMovimiento = tipoMovimiento;
    }
}
