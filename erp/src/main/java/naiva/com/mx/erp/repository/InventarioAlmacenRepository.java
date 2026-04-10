package naiva.com.mx.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import naiva.com.mx.erp.DTO.Responses.InventarioAlmacenResponseDTO;
import naiva.com.mx.erp.model.InventarioAlmacen;

public interface InventarioAlmacenRepository extends JpaRepository<InventarioAlmacen, Integer>{



    String query = "SELECT new naiva.com.mx.erp.DTO.Responses.InventarioAlmacenResponseDTO"+
                    "(ia.idInventarioAlmacen, pv.codigoBarras, p.nombre, sub.nombre, m.valor, um.nombre, ma.nombre, ia.stockActual, ia.ubicacionInterna) "+
                    "FROM InventarioAlmacen ia "+
                    "JOIN ia.productoVariante pv "+
                    "JOIN pv.producto p "+
                    "JOIN p.subcategoria sub "+
                    "JOIN pv.medida m "+
                    "JOIN pv.unidadMedida um "+
                    "JOIN pv.marca ma "+
                    "WHERE ia.almacen.idAlmacen = :idAlmacen";

    @Query(query)
    List<InventarioAlmacenResponseDTO> getInventarioByIdAlmacen(Integer idAlmacen);
}
