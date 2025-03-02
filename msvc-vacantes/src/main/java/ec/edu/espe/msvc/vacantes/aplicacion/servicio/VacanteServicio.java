package ec.edu.espe.msvc.vacantes.aplicacion.servicio;

import ec.edu.espe.msvc.vacantes.aplicacion.usecase.CrearVacanteUseCase;
import ec.edu.espe.msvc.vacantes.aplicacion.usecase.ListarVacanteUseCase;
import ec.edu.espe.msvc.vacantes.dominio.entidades.Requisicion;
import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.RequisicionRepositorio;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.VacanteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Vacante crearVacante(String cargo, String descripcion, String categoriaSalarial, Long idRequisicion) {
        // Obtenemos el objeto Requisicion a partir del idRequisicion
        Requisicion requisicion = requisicionRepositorio.findById(idRequisicion)
                .orElseThrow(() -> new RuntimeException("Requisición no encontrada con ID: " + idRequisicion));

        // Creamos la Vacante, asignando el objeto Requisicion
        Vacante vacante = new Vacante(null, cargo, descripcion, categoriaSalarial, "ABIERTA", null, requisicion);
        
        // Guardamos la vacante
        return vacanteRepositorio.save(vacante);
    }

    public List<Vacante> listarVacantes() {
        return vacanteRepositorio.findAll();
    }

    public List<Vacante> obtenerVacantesPorRequisicion(Long idRequisicion) {
        return vacanteRepositorio.findByRequisicion_IdRequisicion(idRequisicion);
    }
}
