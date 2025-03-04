package ec.edu.espe.msvc.vacantes.presentacion.controlador;

import ec.edu.espe.msvc.vacantes.aplicacion.servicio.VacanteServicio;
import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VacanteController {

    private final VacanteServicio vacanteServicio;

    public VacanteController(VacanteServicio vacanteServicio) {
        this.vacanteServicio = vacanteServicio;
    }
    
    @QueryMapping
    public List<Vacante> listarVacantes() {
        return vacanteServicio.listarVacantes();
    }

    @QueryMapping
    public List<Vacante> obtenerVacantesPorRequisicion(@Argument Long idRequisicion) {
        return vacanteServicio.obtenerVacantesPorRequisicion(idRequisicion);
    }
    
    @QueryMapping
    public Vacante buscarVacantePorId(@Argument Long idVacante) {
        return vacanteServicio.buscarPorId(idVacante).orElse(null);
    }


    @MutationMapping
    public Vacante crearVacante(
            @Argument String cargo,
            @Argument String descripcion,
            @Argument String categoriaSalarial,
            @Argument Long idRequisicion,
            @Argument int cantidadMaximaPostulaciones ) {
        return vacanteServicio.crearVacante(cargo, descripcion, categoriaSalarial, idRequisicion, cantidadMaximaPostulaciones);
    }
    
    @MutationMapping
    public String eliminarVacante(@Argument Long idVacante) {
        return vacanteServicio.eliminarVacante(idVacante);
    }

}
