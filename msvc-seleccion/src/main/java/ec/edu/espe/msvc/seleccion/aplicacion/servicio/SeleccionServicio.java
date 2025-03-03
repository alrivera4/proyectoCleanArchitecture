package ec.edu.espe.msvc.seleccion.aplicacion.servicio;

import ec.edu.espe.msvc.seleccion.dominio.entidades.Seleccion;
import ec.edu.espe.msvc.seleccion.dominio.entidades.Candidato;
import ec.edu.espe.msvc.seleccion.dominio.entidades.Vacante;
import ec.edu.espe.msvc.seleccion.dominio.repositorio.CandidatoRepositorio;
import ec.edu.espe.msvc.seleccion.dominio.repositorio.SeleccionRepositorio;
import ec.edu.espe.msvc.seleccion.dominio.repositorio.VacanteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeleccionServicio {

    private final SeleccionRepositorio seleccionRepositorio;
    private final CandidatoRepositorio candidatoRepositorio;
    private final VacanteRepositorio vacanteRepositorio;

    public List<Seleccion> obtenerTodas() {
        return seleccionRepositorio.findAll();
    }

    public Seleccion obtenerPorId(Long id) {
        return seleccionRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Selección no encontrada con ID: " + id));
    }

    public Seleccion guardar(Long idCandidato, Long idVacante, String resultadoEvaluacion, String recomendaciones) {
        Candidato candidato = candidatoRepositorio.findById(idCandidato)
                .orElseThrow(() -> new RuntimeException("Candidato no encontrado con ID: " + idCandidato));

        Vacante vacante = vacanteRepositorio.findById(idVacante)
                .orElseThrow(() -> new RuntimeException("Vacante no encontrada con ID: " + idVacante));

        Seleccion seleccion = Seleccion.builder()
                .candidato(candidato)
                .vacante(vacante)
                .resultadoEvaluacion(resultadoEvaluacion)
                .recomendaciones(recomendaciones)
                .build();

        return seleccionRepositorio.save(seleccion);
    }

    public void eliminar(Long id) {
        Seleccion seleccion = obtenerPorId(id);
        seleccionRepositorio.delete(seleccion);
    }
}
