package ec.edu.espe.msvc.entrevistas.aplicacion.servicio;

import ec.edu.espe.msvc.entrevistas.dominio.entidades.Candidato;
import ec.edu.espe.msvc.entrevistas.dominio.entidades.Entrevista;
import ec.edu.espe.msvc.entrevistas.dominio.entidades.Vacante;
import ec.edu.espe.msvc.entrevistas.dominio.repositorio.CandidatoRepositorio;
import ec.edu.espe.msvc.entrevistas.dominio.repositorio.EntrevistaRepositorio;
import ec.edu.espe.msvc.entrevistas.dominio.repositorio.VacanteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrevistaServicio {

    @Autowired
    private EntrevistaRepositorio entrevistaRepositorio;

    @Autowired
    private CandidatoRepositorio candidatoRepositorio;  // Inyectamos el repositorio de Candidato

    @Autowired
    private VacanteRepositorio vacanteRepositorio;      // Inyectamos el repositorio de Vacante

    // Lógica de negocio para crear una nueva entrevista
    public Entrevista crearEntrevista(Entrevista entrevista) {
        return entrevistaRepositorio.save(entrevista);
    }

    // Lógica de negocio para obtener todas las entrevistas de un candidato
    public List<Entrevista> obtenerEntrevistasPorCandidato(Long idCandidato) {
        return entrevistaRepositorio.findByCandidato_IdCandidato(idCandidato);
    }

    // Lógica de negocio para obtener una entrevista por ID
    public Optional<Entrevista> obtenerEntrevistaPorId(Long id) {
        return entrevistaRepositorio.findById(id);
    }

    // Lógica de negocio para eliminar una entrevista
    public void eliminarEntrevista(Long id) {
        entrevistaRepositorio.deleteById(id);
    }

    // Método para obtener candidato por ID
    public Optional<Candidato> obtenerCandidatoPorId(Long idCandidato) {
        return candidatoRepositorio.findById(idCandidato);
    }

    // Método para obtener vacante por ID
    public Optional<Vacante> obtenerVacantePorId(Long idVacante) {
        return vacanteRepositorio.findById(idVacante);
    }
}
