package naiva.com.mx.erp.repository.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import naiva.com.mx.erp.model.producto.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
