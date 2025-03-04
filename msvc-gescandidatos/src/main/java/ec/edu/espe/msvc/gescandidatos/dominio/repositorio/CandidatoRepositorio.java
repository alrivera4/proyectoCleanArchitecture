package ec.edu.espe.msvc.gescandidatos.dominio.repositorio;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepositorio extends JpaRepository<Candidato, Long> {
    // Buscar todos los candidatos con un estado específico
    List<Candidato> findByEstado(String estado);
    int countByVacanteIdVacante(Long idVacante);
}
