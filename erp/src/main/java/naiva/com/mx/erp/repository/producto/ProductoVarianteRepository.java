package naiva.com.mx.erp.repository.producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import naiva.com.mx.erp.DTO.Responses.ProductoVarianteResponseDTO;
import naiva.com.mx.erp.model.producto.ProductoVariante;

public interface ProductoVarianteRepository extends JpaRepository<ProductoVariante, Integer> {
    String query = "SELECT new naiva.com.mx.erp.DTO.Responses.ProductoVarianteResponseDTO "+
                          "(pv.codigoBarras, p.nombre, p.descripcion, mt.nombre, "+
                          "me.valor, ma.nombre, um.nombre, sub.nombre, cat.nombre) "+
                          "FROM ProductoVariante pv "+
                          "JOIN pv.producto p "+
                          "JOIN pv.materialTrabajo mt "+
                          "JOIN pv.medida me "+
                          "JOIN pv.marca ma "+
                          "JOIN pv.unidadMedida um "+
                          "JOIN p.subcategoria sub "+
                          "JOIN sub.categoria cat";

    @Query(query)
    List<ProductoVarianteResponseDTO> findAllProductosVariante();
}
