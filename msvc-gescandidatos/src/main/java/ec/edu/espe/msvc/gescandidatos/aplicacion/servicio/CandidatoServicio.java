package ec.edu.espe.msvc.gescandidatos.aplicacion.servicio;

import ec.edu.espe.msvc.gescandidatos.aplicacion.servicio.usecase.BuscarCandidatoUseCase;
import ec.edu.espe.msvc.gescandidatos.aplicacion.servicio.usecase.CrearCandidatoUseCase;
import ec.edu.espe.msvc.gescandidatos.aplicacion.servicio.usecase.EliminarCandidatoUseCase;
import ec.edu.espe.msvc.gescandidatos.aplicacion.servicio.usecase.ListarCandidatosUseCase;
import ec.edu.espe.msvc.gescandidatos.aplicacion.servicio.usecase.ModificarEstadoCandidatoUseCase;
import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoServicio {

    private final BuscarCandidatoUseCase buscarCandidatoUseCase;
    private final CrearCandidatoUseCase crearCandidatoUseCase;
    private final EliminarCandidatoUseCase eliminarCandidatoUseCase;
    private final ListarCandidatosUseCase listarCandidatosUseCase; // ✅ Nuevo caso de uso
    private final ModificarEstadoCandidatoUseCase modificarEstadoCandidatoUseCase;

    public CandidatoServicio(BuscarCandidatoUseCase buscarCandidatoUseCase,
                             CrearCandidatoUseCase crearCandidatoUseCase,
                             EliminarCandidatoUseCase eliminarCandidatoUseCase,
                             ListarCandidatosUseCase listarCandidatosUseCase,
                             ModificarEstadoCandidatoUseCase modificarEstadoCandidatoUseCase) {
        
        
        this.buscarCandidatoUseCase = buscarCandidatoUseCase;
        this.crearCandidatoUseCase = crearCandidatoUseCase;
        this.eliminarCandidatoUseCase = eliminarCandidatoUseCase;
        this.modificarEstadoCandidatoUseCase = modificarEstadoCandidatoUseCase;
        this.listarCandidatosUseCase = listarCandidatosUseCase;
    }

    public List<Candidato> listarCandidatos() {
        return listarCandidatosUseCase.ejecutar(); 
    }

    public Optional<Candidato> buscarCandidato(Long id) {
        return buscarCandidatoUseCase.ejecutar(id);
    }

    public Candidato guardarCandidato(Candidato candidato) {
        return crearCandidatoUseCase.ejecutar(candidato);
    }

    public void eliminarCandidato(Long id) {
        eliminarCandidatoUseCase.ejecutar(id);
    }

    public Optional<Candidato> actualizarEstadoCandidato(Long id, String nuevoEstado) {
        return modificarEstadoCandidatoUseCase.ejecutar(id, nuevoEstado);
    }

    public List<Candidato> listarPorEstado(String estado) {
        return listarCandidatosUseCase.listarPorEstado(estado);
    }
}
