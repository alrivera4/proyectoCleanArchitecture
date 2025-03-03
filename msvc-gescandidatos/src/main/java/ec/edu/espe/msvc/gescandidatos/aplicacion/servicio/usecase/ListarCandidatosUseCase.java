package ec.edu.espe.msvc.gescandidatos.aplicacion.usecase;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarCandidatosUseCase {
    private final CandidatoRepositorio repositorio;

    public ListarCandidatosUseCase(CandidatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Candidato> ejecutar() {
        return repositorio.listarTodas();
    }
}
