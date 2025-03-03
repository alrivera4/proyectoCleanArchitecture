package ec.edu.espe.msvc.seleccion.presentacion.controlador;

import ec.edu.espe.msvc.seleccion.aplicacion.servicio.SeleccionServicio;
import ec.edu.espe.msvc.seleccion.dominio.entidades.Seleccion;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SeleccionController {

    private final SeleccionServicio seleccionServicio;

    @QueryMapping
    public List<Seleccion> obtenerTodasLasSelecciones() {
        return seleccionServicio.obtenerTodas();
    }

    @QueryMapping
    public Seleccion obtenerSeleccionPorId(@Argument Long id) {
        return seleccionServicio.obtenerPorId(id);
    }

    @MutationMapping
    public Seleccion guardarSeleccion(@Argument Long idCandidato, @Argument Long idVacante,
                                      @Argument String resultadoEvaluacion, @Argument String recomendaciones) {
        return seleccionServicio.guardar(idCandidato, idVacante, resultadoEvaluacion, recomendaciones);
    }

    @MutationMapping
    public Boolean eliminarSeleccion(@Argument Long id) {
        seleccionServicio.eliminar(id);
        return true;
    }
}
