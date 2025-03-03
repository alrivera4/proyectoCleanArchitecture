package ec.edu.espe.msvc.vacantes.aplicacion.usecase;

import ec.edu.espe.msvc.vacantes.dominio.entidades.Requisicion;
import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.RequisicionRepositorio; // Asegúrate de tener este repositorio
import ec.edu.espe.msvc.vacantes.dominio.repositorio.VacanteRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CrearVacanteUseCase {

    private final VacanteRepositorio vacanteRepositorio;
    private final RequisicionRepositorio requisicionRepositorio; // Repositorio para Requisicion

    public CrearVacanteUseCase(VacanteRepositorio vacanteRepositorio, RequisicionRepositorio requisicionRepositorio) {
        this.vacanteRepositorio = vacanteRepositorio;
        this.requisicionRepositorio = requisicionRepositorio; // Inicialización del repositorio
    }

    public Vacante ejecutar(String cargo, String descripcion, String categoriaSalarial, Long idRequisicion) {
        // Obtenemos la Requisicion a partir del idRequisicion
        Requisicion requisicion = requisicionRepositorio.findById(idRequisicion)
                .orElseThrow(() -> new RuntimeException("Requisición no encontrada con ID: " + idRequisicion));

        // Creamos la Vacante con el objeto Requisicion
        Vacante vacante = Vacante.builder()
                .cargo(cargo)
                .descripcion(descripcion)
                .categoriaSalarial(categoriaSalarial)
                .estado("ABIERTA")
                .fechaPublicacion(LocalDate.now())
                .requisicion(requisicion) // Asignamos el objeto Requisicion
                .build();

        // Guardamos la vacante
        return vacanteRepositorio.save(vacante);
    }
}
