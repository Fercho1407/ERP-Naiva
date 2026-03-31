package naiva.com.mx.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import naiva.com.mx.erp.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    
}