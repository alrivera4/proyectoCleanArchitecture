package ec.edu.espe.msvc.gescandidatos.aplicacion.usecase;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarCandidatoUseCase {
    private final CandidatoRepositorio repositorio;

    public BuscarCandidatoUseCase(CandidatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Optional<Candidato> ejecutar(Long id) {
        return repositorio.buscarPorId(id);
    }
}
