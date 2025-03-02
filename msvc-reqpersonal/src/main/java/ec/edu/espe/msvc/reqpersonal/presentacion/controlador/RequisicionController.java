package ec.edu.espe.msvc.reqpersonal.presentacion.controlador;

import ec.edu.espe.msvc.reqpersonal.aplicacion.servicio.RequisicionServicio;
import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RequisicionController {

    private final RequisicionServicio servicio;

    public RequisicionController(RequisicionServicio servicio) {
        this.servicio = servicio;
    }

    @QueryMapping
    public List<Requisicion> listarRequisiciones() {
        return servicio.listarRequisiciones();
    }

    @MutationMapping
    public Requisicion crearRequisicion(
            @Argument String cargo,
            @Argument String descripcion,
            @Argument String categoriaSalarial
    ) {
        return servicio.crearRequisicion(cargo, descripcion, categoriaSalarial);
    }

    @MutationMapping
    public String eliminarRequisicion(@Argument Long id) {
        servicio.eliminarRequisicion(id);
        return "Requisición eliminada con éxito.";
    }

    @QueryMapping
    public List<Requisicion> listarRequisicionesAprobadas() {
        return servicio.listarRequisicionesAprobadas();
    }
}
