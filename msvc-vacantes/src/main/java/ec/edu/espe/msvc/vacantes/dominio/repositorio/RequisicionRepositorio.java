package ec.edu.espe.msvc.vacantes.dominio.repositorio;

import ec.edu.espe.msvc.vacantes.dominio.entidades.Requisicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicionRepositorio extends JpaRepository<Requisicion, Long> {
}
