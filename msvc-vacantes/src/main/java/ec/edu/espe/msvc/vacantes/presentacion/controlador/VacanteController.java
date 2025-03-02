package ec.edu.espe.msvc.vacantes.presentacion.controlador;

import ec.edu.espe.msvc.vacantes.aplicacion.servicio.VacanteServicio;
import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import org.springframework.graphql.data.method.annotation.Argument;
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
    public List<Vacante> obtenerVacantesPorRequisicion(@Argument Long idRequisicion) {
        return vacanteServicio.obtenerVacantesPorRequisicion(idRequisicion); // 🔹 Corregido
    }
}
