package ec.edu.espe.msvc.reqpersonal.aplicacion.usecases;

import ec.edu.espe.msvc.reqpersonal.dominio.repositorio.RequisicionRepositorio;
import org.springframework.stereotype.Service;

@Service
public class EliminarRequisicionUseCase {

    private final RequisicionRepositorio repositorio;

    public EliminarRequisicionUseCase(RequisicionRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Long id) {
        repositorio.deleteById(id); // Se usa deleteById() directamente de JpaRepository
    }
}
