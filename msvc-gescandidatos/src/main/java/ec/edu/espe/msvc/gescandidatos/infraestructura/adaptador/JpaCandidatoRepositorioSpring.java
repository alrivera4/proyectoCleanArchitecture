package ec.edu.espe.msvc.gescandidatos.infraestructura.adaptador;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCandidatoRepositorioSpring extends JpaRepository<Candidato, Long> {
    List<Candidato> findByEstado(String estado);
}
