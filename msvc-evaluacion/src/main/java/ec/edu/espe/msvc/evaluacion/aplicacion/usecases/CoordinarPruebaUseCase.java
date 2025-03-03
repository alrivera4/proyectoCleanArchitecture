package ec.edu.espe.msvc.evaluacion.aplicacion.usecases;

import ec.edu.espe.msvc.evaluacion.dominio.entidades.Candidato;
import ec.edu.espe.msvc.evaluacion.dominio.entidades.Prueba;
import ec.edu.espe.msvc.evaluacion.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import ec.edu.espe.msvc.evaluacion.dominio.repositorio.PruebaRepositorio;
import java.util.Optional;

@Service
public class CoordinarPruebaUseCase {

    private final PruebaRepositorio evaluacionRepositorio;
    private final CandidatoRepositorio candidatoRepositorio;  
    
    public CoordinarPruebaUseCase(PruebaRepositorio evaluacionRepositorio, CandidatoRepositorio candidatoRepositorio) {
        this.evaluacionRepositorio = evaluacionRepositorio;
        this.candidatoRepositorio = candidatoRepositorio;
    }

    public List<Prueba> obtenerPruebasActivas() {
        return evaluacionRepositorio.findByActiva(true);
    }

    public List<Prueba> obtenerPruebasPorTipo(String tipo) {
        return evaluacionRepositorio.findByTipo(tipo);
    }

    public Prueba coordinarPrueba(Prueba prueba) {
        return evaluacionRepositorio.save(prueba);
    }
    
    public List<Prueba> obtenerPruebasPorCandidato(Long candidatoId) {
    return evaluacionRepositorio.findByCandidato_IdCandidato(candidatoId);
}

    public Optional<Prueba> obtenerPruebaPorId(Long id) {
        return evaluacionRepositorio.findById(id);
    }
    
    public Optional<Candidato> obtenerCandidatoPorId(Long id) {
        return candidatoRepositorio.findById(id);
    }

    public void eliminarPrueba(Long id) {
        evaluacionRepositorio.deleteById(id);
    }
}
