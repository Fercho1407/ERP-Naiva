package naiva.com.mx.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import naiva.com.mx.erp.model.Estado;


public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    Estado findByEstado(String estado);
}
