package ec.edu.espe.msvc.gescandidatos.aplicacion.usecases;

import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class EliminarCandidatoUseCase {
    private final CandidatoRepositorio repositorio;

    public EliminarCandidatoUseCase(CandidatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Long id) {
        repositorio.deleteById(id);
    }
}
