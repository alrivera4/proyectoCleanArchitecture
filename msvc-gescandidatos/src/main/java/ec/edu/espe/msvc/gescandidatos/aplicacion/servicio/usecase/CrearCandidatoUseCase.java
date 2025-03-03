package ec.edu.espe.msvc.gescandidatos.aplicacion.usecase;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class CrearCandidatoUseCase {
    private final CandidatoRepositorio repositorio;

    public CrearCandidatoUseCase(CandidatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Candidato ejecutar(Candidato candidato) {
        return repositorio.guardar(candidato);
    }
}
