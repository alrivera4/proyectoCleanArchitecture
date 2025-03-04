package ec.edu.espe.msvc.gescandidatos.aplicacion.servicio;

import ec.edu.espe.msvc.gescandidatos.aplicacion.usecases.BuscarCandidatoUseCase;
import ec.edu.espe.msvc.gescandidatos.aplicacion.usecases.CrearCandidatoUseCase;
import ec.edu.espe.msvc.gescandidatos.aplicacion.usecases.EliminarCandidatoUseCase;
import ec.edu.espe.msvc.gescandidatos.aplicacion.usecases.ListarCandidatosUseCase;
import ec.edu.espe.msvc.gescandidatos.aplicacion.usecases.ModificarEstadoCandidatoUseCase;
import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Vacante;
import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.VacanteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoServicio {

    private final BuscarCandidatoUseCase buscarCandidatoUseCase;
    private final CrearCandidatoUseCase crearCandidatoUseCase;
    private final EliminarCandidatoUseCase eliminarCandidatoUseCase;
    private final ListarCandidatosUseCase listarCandidatosUseCase;
    private final ModificarEstadoCandidatoUseCase modificarEstadoCandidatoUseCase;
    private final VacanteRepositorio vacanteRepositorio; // Para acceder a la vacante

    public CandidatoServicio(BuscarCandidatoUseCase buscarCandidatoUseCase,
                             CrearCandidatoUseCase crearCandidatoUseCase,
                             EliminarCandidatoUseCase eliminarCandidatoUseCase,
                             ListarCandidatosUseCase listarCandidatosUseCase,
                             ModificarEstadoCandidatoUseCase modificarEstadoCandidatoUseCase,
                             VacanteRepositorio vacanteRepositorio) {
        
        this.buscarCandidatoUseCase = buscarCandidatoUseCase;
        this.crearCandidatoUseCase = crearCandidatoUseCase;
        this.eliminarCandidatoUseCase = eliminarCandidatoUseCase;
        this.modificarEstadoCandidatoUseCase = modificarEstadoCandidatoUseCase;
        this.listarCandidatosUseCase = listarCandidatosUseCase;
        this.vacanteRepositorio = vacanteRepositorio;
    }

    public List<Candidato> listarCandidatos() {
        return listarCandidatosUseCase.ejecutar();
    }

    public Optional<Candidato> buscarCandidato(Long id) {
        return buscarCandidatoUseCase.ejecutar(id);
    }

  /*  public Candidato guardarCandidato(Candidato candidato, Long idVacante) {
        // Lógica para verificar si la vacante tiene espacio para más postulaciones
        Vacante vacante = vacanteRepositorio.findById(idVacante)
                .orElseThrow(() -> new IllegalArgumentException("Vacante no encontrada"));

        int cantidadPostulaciones = contarPostulaciones(idVacante);
        int cantidadMaximaPostulaciones = vacante.getCantidadMaximaPostulaciones();

        if (cantidadPostulaciones >= cantidadMaximaPostulaciones) {
            throw new IllegalStateException("Esta vacante ya ha alcanzado el límite de postulaciones.");
        }

        // Guardar el candidato si no se supera el límite de postulaciones
        candidato.setVacante(vacante);
        return crearCandidatoUseCase.ejecutar(candidato);
    }
*/
  /*  public Candidato guardarCandidato(Candidato candidato, Long idVacante) {
        // Obtener la vacante por ID
        Vacante vacante = vacanteRepositorio.findById(idVacante)
                .orElseThrow(() -> new IllegalArgumentException("Vacante no encontrada"));

        int cantidadPostulaciones = contarPostulaciones(idVacante);
        int cantidadMaximaPostulaciones = vacante.getCantidadMaximaPostulaciones();

        if (cantidadPostulaciones >= cantidadMaximaPostulaciones) {
            // 🔹 Cambiar estado de la vacante a "CERRADA" si alcanza el límite de postulaciones
            vacante.setEstado("CERRADA");
            vacanteRepositorio.save(vacante);  // 🔹 Guardamos el nuevo estado en la BD
            //throw new IllegalStateException("Esta vacante ha alcanzado el límite y ha sido cerrada.");
        }

        // Guardar el candidato si aún hay espacio
        candidato.setVacante(vacante);
        Candidato nuevoCandidato = crearCandidatoUseCase.ejecutar(candidato);

        // 🔹 Verificar si se alcanzó el límite después de guardar el candidato
        if (contarPostulaciones(idVacante) >= cantidadMaximaPostulaciones) {
            vacante.setEstado("CERRADA");
            vacanteRepositorio.save(vacante);  // 🔹 Guardamos el nuevo estado en la BD
        }

        return nuevoCandidato;
    }*/
    public String guardarCandidato(Candidato candidato, Long idVacante) {
        // Obtener la vacante por ID
        Vacante vacante = vacanteRepositorio.findById(idVacante)
                .orElseThrow(() -> new IllegalArgumentException("Vacante no encontrada"));

        int cantidadPostulaciones = contarPostulaciones(idVacante);
        int cantidadMaximaPostulaciones = vacante.getCantidadMaximaPostulaciones();

        if (cantidadPostulaciones >= cantidadMaximaPostulaciones) {
            // 🔹 Cambiar estado de la vacante a "CERRADA" si alcanza el límite de postulaciones
            vacante.setEstado("CERRADA");
            vacanteRepositorio.save(vacante);  // 🔹 Guardamos el nuevo estado en la BD

            return "Esta vacante ha alcanzado el límite y ha sido cerrada.";  // ✅ En lugar de lanzar una excepción, retornamos un mensaje manejado.
        }

        // Guardar el candidato si aún hay espacio
        candidato.setVacante(vacante);
        Candidato nuevoCandidato = crearCandidatoUseCase.ejecutar(candidato);

        // 🔹 Verificar si se alcanzó el límite después de guardar el candidato
        cantidadPostulaciones = contarPostulaciones(idVacante);
        if (cantidadPostulaciones >= cantidadMaximaPostulaciones) {
            vacante.setEstado("CERRADA");
            vacanteRepositorio.save(vacante);
        }

        return "Candidato registrado exitosamente.";  // ✅ Mensaje cuando el candidato se guarda correctamente
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

    private int contarPostulaciones(Long idVacante) {
        // Lógica para contar las postulaciones de la vacante
        // Este método puede usar un repositorio de candidatos, o se podría agregar una consulta personalizada
        return listarCandidatosUseCase.contarPorVacante(idVacante);
    }
}