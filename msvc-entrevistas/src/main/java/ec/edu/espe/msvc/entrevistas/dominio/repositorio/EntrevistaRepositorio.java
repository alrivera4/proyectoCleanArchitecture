package ec.edu.espe.msvc.entrevistas.dominio.repositorio;

import ec.edu.espe.msvc.entrevistas.dominio.entidades.Entrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntrevistaRepositorio extends JpaRepository<Entrevista, Long> {
    List<Entrevista> findByCandidato_IdCandidato(Long idCandidato);  // Accediendo al 'id' de la relación candidato
}
