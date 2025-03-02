package ec.edu.espe.msvc.reqpersonal.aplicacion.servicio;

import ec.edu.espe.msvc.reqpersonal.aplicacion.usecases.CrearRequisicionUseCase;
import ec.edu.espe.msvc.reqpersonal.aplicacion.usecases.EliminarRequisicionUseCase;
import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import ec.edu.espe.msvc.reqpersonal.dominio.repositorio.RequisicionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequisicionServicio {

    private final CrearRequisicionUseCase crearRequisicionUseCase;
    private final EliminarRequisicionUseCase eliminarRequisicionUseCase;
    private final RequisicionRepositorio repositorio;

    public RequisicionServicio(CrearRequisicionUseCase crearRequisicionUseCase,
                               EliminarRequisicionUseCase eliminarRequisicionUseCase,
                               RequisicionRepositorio repositorio) {
        this.crearRequisicionUseCase = crearRequisicionUseCase;
        this.eliminarRequisicionUseCase = eliminarRequisicionUseCase;
        this.repositorio = repositorio;
    }

    public Requisicion crearRequisicion(String cargo, String descripcion, String categoriaSalarial) {
        return crearRequisicionUseCase.ejecutar(cargo, descripcion, categoriaSalarial);
    }

    public List<Requisicion> listarRequisiciones() {
        return repositorio.listarTodas();
    }

    public Optional<Requisicion> obtenerRequisicionPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public void eliminarRequisicion(Long id) {
        eliminarRequisicionUseCase.ejecutar(id);
    }

    public Requisicion actualizarEstadoRequisicion(Long id, String nuevoEstado) {
        return repositorio.buscarPorId(id)
                .map(requisicion -> {
                    requisicion.setEstado(nuevoEstado);
                    return repositorio.guardar(requisicion);
                })
                .orElseThrow(() -> new RuntimeException("Requisición no encontrada con ID: " + id));
    }

    public List<Requisicion> listarRequisicionesAprobadas() {
        return repositorio.findByEstado("APROBADA");
    }
}
