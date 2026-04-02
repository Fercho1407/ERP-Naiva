package naiva.com.mx.erp.repository.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import naiva.com.mx.erp.model.producto.MaterialTrabajo;

@Repository
public interface MaterialTrabajoRepository extends JpaRepository<MaterialTrabajo, Integer>{
    
}
