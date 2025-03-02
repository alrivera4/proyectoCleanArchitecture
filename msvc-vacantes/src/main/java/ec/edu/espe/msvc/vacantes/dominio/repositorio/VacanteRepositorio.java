package ec.edu.espe.msvc.vacantes.dominio.repositorio;

import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacanteRepositorio extends JpaRepository<Vacante, Long> {

    List<Vacante> findByIdRequisicion(Long idRequisicion); // 🔹 Buscar vacantes por idRequisicion

}
