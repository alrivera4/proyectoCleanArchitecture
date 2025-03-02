package ec.edu.espe.msvc.vacantes.aplicacion.usecase;

import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.VacanteRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CrearVacanteUseCase {

    private final VacanteRepositorio repositorio;

    public CrearVacanteUseCase(VacanteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Vacante ejecutar(String cargo, String descripcion, String categoriaSalarial, Long idRequisicion) {
        Vacante vacante = Vacante.builder()
                .cargo(cargo)
                .descripcion(descripcion)
                .categoriaSalarial(categoriaSalarial)
                .estado("ABIERTA")
                .fechaPublicacion(LocalDate.now())
                .idRequisicion(idRequisicion)
                .build();
        return repositorio.save(vacante);
    }
}
