package ec.edu.espe.msvc.evaluacion.dominio.repositorio;

import ec.edu.espe.msvc.evaluacion.dominio.entidades.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PruebaRepositorio extends JpaRepository<Prueba, Long> {
    List<Prueba> findByActiva(boolean activa);
    List<Prueba> findByTipo(String tipo);
    List<Prueba> findByCandidato_IdCandidato(Long idCandidato);

}