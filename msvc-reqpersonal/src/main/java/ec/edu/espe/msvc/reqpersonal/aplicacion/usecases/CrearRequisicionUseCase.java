package ec.edu.espe.msvc.reqpersonal.aplicacion.usecases;

import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import ec.edu.espe.msvc.reqpersonal.dominio.repositorio.RequisicionRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CrearRequisicionUseCase {

    private final RequisicionRepositorio repositorio;

    public CrearRequisicionUseCase(RequisicionRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Requisicion ejecutar(String cargo, String descripcion, String categoriaSalarial) {
        Requisicion requisicion = Requisicion.builder()  // ✅ Usando Builder correctamente
                .cargo(cargo)
                .descripcion(descripcion)
                .categoriaSalarial(categoriaSalarial)
                .estado("PENDIENTE")
                .fechaSolicitud(LocalDate.now())
                .build();

        return repositorio.guardar(requisicion);
    }
}
