package naiva.com.mx.erp.DTO.movimientosInventario;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import naiva.com.mx.erp.model.ENUM.Tipomovimiento;

@Data
@AllArgsConstructor
public class RegistroEntradaResponseDTO {
    private Tipomovimiento tipomovimiento;
    private Instant fechaMovimiento;
    private String observaciones;
}
