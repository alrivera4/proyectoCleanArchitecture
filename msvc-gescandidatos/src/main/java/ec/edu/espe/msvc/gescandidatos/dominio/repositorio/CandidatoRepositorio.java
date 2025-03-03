package ec.edu.espe.msvc.gescandidatos.dominio.repositorio;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatoRepositorio {

    // Buscar todos los candidatos con un estado específico
    List<Candidato> findByEstado(String estado);

    // Listar todos los candidatos
    List<Candidato> listarTodas();

    // Guardar o actualizar un candidato
    Candidato guardar(Candidato candidato);

    // Eliminar un candidato por ID
    void eliminar(Long id);

    // Buscar un candidato por ID
    Optional<Candidato> buscarPorId(Long id);
}
