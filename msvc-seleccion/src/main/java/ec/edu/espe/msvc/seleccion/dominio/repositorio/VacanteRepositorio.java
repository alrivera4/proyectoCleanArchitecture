package ec.edu.espe.msvc.seleccion.dominio.repositorio;

import ec.edu.espe.msvc.seleccion.dominio.entidades.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacanteRepositorio extends JpaRepository<Vacante, Long> {
}
