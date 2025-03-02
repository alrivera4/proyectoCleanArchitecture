package ec.edu.espe.msvc.reqpersonal.dominio.repositorio;

import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisicionRepositorio extends JpaRepository<Requisicion, Long> {
    List<Requisicion> findByEstado(String estado);
}
