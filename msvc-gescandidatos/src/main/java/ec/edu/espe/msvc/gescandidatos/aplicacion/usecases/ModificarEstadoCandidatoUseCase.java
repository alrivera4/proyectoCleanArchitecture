package ec.edu.espe.msvc.gescandidatos.aplicacion.usecases;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModificarEstadoCandidatoUseCase {
    private final CandidatoRepositorio repositorio;

    public ModificarEstadoCandidatoUseCase(CandidatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Optional<Candidato> ejecutar(Long id, String nuevoEstado) {
        Optional<Candidato> candidatoOpt = repositorio.findById(id);

        if (candidatoOpt.isPresent()) {
            Candidato candidato = candidatoOpt.get();
            candidato.setEstado(nuevoEstado);
            return Optional.of(repositorio.save(candidato));
        }

        return Optional.empty();
    }
}
