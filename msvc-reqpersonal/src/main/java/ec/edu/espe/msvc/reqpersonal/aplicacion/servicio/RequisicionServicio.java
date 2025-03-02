package ec.edu.espe.msvc.reqpersonal.aplicacion.servicio;

import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import ec.edu.espe.msvc.reqpersonal.dominio.repositorio.RequisicionRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RequisicionServicio {

    private final RequisicionRepositorio repositorio;

    public RequisicionServicio(RequisicionRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Requisicion crearRequisicion(String cargo, String descripcion, String categoriaSalarial) {
        return repositorio.save(Requisicion.builder()
                .cargo(cargo)
                .descripcion(descripcion)
                .categoriaSalarial(categoriaSalarial)
                .estado("PENDIENTE")
                .fechaSolicitud(LocalDate.now())
                .build());
    }

    public List<Requisicion> listarRequisiciones() {
        return repositorio.findAll();
    }

    public Optional<Requisicion> obtenerRequisicionPorId(Long id) {
        return repositorio.findById(id);
    }

    public void eliminarRequisicion(Long id) {
        repositorio.deleteById(id);
    }

    public Requisicion actualizarEstadoRequisicion(Long id, String nuevoEstado) {
        Optional<Requisicion> requisicionOpt = repositorio.findById(id);
        if (requisicionOpt.isPresent()) {
            Requisicion requisicion = requisicionOpt.get();
            requisicion.setEstado(nuevoEstado);
            return repositorio.save(requisicion);
        } else {
            throw new RuntimeException("Requisición no encontrada con ID: " + id);
        }
    }

    public List<Requisicion> listarRequisicionesAprobadas() {
        return repositorio.findByEstado("APROBADA");
    }
}
