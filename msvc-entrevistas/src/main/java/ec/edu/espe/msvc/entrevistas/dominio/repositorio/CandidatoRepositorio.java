package ec.edu.espe.msvc.entrevistas.dominio.repositorio;

import ec.edu.espe.msvc.entrevistas.dominio.entidades.Candidato;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepositorio extends JpaRepository<Candidato, Long> {

}
