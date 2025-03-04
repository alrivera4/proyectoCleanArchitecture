package ec.edu.espe.msvc.vacantes.aplicacion.servicio;

import ec.edu.espe.msvc.vacantes.aplicacion.usecase.CrearVacanteUseCase;
import ec.edu.espe.msvc.vacantes.aplicacion.usecase.ListarVacanteUseCase;
import ec.edu.espe.msvc.vacantes.dominio.entidades.Requisicion;
import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.RequisicionRepositorio;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.VacanteRepositorio;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacanteServicio {

    private final CrearVacanteUseCase crearVacanteUseCase;
    private final ListarVacanteUseCase listarVacanteUseCase;
    private final VacanteRepositorio vacanteRepositorio;
    private final RequisicionRepositorio requisicionRepositorio;  // Repositorio de Requisicion

    public VacanteServicio(CrearVacanteUseCase crearVacanteUseCase,
                           ListarVacanteUseCase listarVacanteUseCase,
                           VacanteRepositorio vacanteRepositorio,
                           RequisicionRepositorio requisicionRepositorio) {
        this.crearVacanteUseCase = crearVacanteUseCase;
        this.listarVacanteUseCase = listarVacanteUseCase;
        this.vacanteRepositorio = vacanteRepositorio;
        this.requisicionRepositorio = requisicionRepositorio;  // Inicialización del repositorio de Requisicion
    }

    public Vacante crearVacante(String cargo, String descripcion, String categoriaSalarial, Long idRequisicion, int cantidadMaximaPostulaciones) {
        Requisicion requisicion = requisicionRepositorio.findById(idRequisicion)
                .orElseThrow(() -> new RuntimeException("Requisición no encontrada con ID: " + idRequisicion));

        Vacante vacante = new Vacante(null, cargo, descripcion, categoriaSalarial, "ABIERTA", LocalDate.now(), cantidadMaximaPostulaciones, requisicion);


        Vacante nuevaVacante = vacanteRepositorio.save(vacante);

        // 🔹 Aseguramos que se retorne la vacante con el ID generado por la base de datos
        return vacanteRepositorio.findById(nuevaVacante.getIdVacante()).orElseThrow(() -> 
            new RuntimeException("Error al recuperar la vacante creada"));
    }


    public List<Vacante> listarVacantes() {
        return vacanteRepositorio.findAll();
    }

    public List<Vacante> obtenerVacantesPorRequisicion(Long idRequisicion) {
        return vacanteRepositorio.findByRequisicion_IdRequisicion(idRequisicion);
    }
    public Optional<Vacante> buscarPorId(Long idVacante) {
        return vacanteRepositorio.findById(idVacante);
    }
    public String eliminarVacante(Long idVacante) {
        Vacante vacante = vacanteRepositorio.findById(idVacante)
                .orElseThrow(() -> new RuntimeException("Vacante no encontrada con ID: " + idVacante));

        vacante.setEstado("CANCELADA"); // 🔹 Cambio de estado en lugar de eliminar
        vacanteRepositorio.save(vacante); // 🔹 Guardamos la actualización

        return "Vacante marcada como CANCELADA.";
    }



}
