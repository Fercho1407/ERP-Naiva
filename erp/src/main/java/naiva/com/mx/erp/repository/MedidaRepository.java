package naiva.com.mx.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import naiva.com.mx.erp.model.Medida;


public interface MedidaRepository extends JpaRepository <Medida, Integer> {
    Medida findByMedidaAndUnidadMedida(String medida, String unidadMedida);
}