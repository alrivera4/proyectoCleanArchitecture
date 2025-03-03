package ec.edu.espe.msvc.seleccion.aplicacion.usecases;

import ec.edu.espe.msvc.seleccion.aplicacion.servicio.SeleccionServicio;
import ec.edu.espe.msvc.seleccion.dominio.entidades.Seleccion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeleccionUseCase {

    private final SeleccionServicio seleccionServicio;

    public List<Seleccion> obtenerTodasLasSelecciones() {
        return seleccionServicio.obtenerTodas();
    }

    public Seleccion obtenerSeleccionPorId(Long id) {
        return seleccionServicio.obtenerPorId(id);
    }

    public Seleccion crearSeleccion(Long idCandidato, Long idVacante, String resultadoEvaluacion, String recomendaciones) {
        return seleccionServicio.guardar(idCandidato, idVacante, resultadoEvaluacion, recomendaciones);
    }

    public boolean eliminarSeleccion(Long id) {
        seleccionServicio.eliminar(id);
        return true;
    }
}
