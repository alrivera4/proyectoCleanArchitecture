package ec.edu.espe.msvc.reqpersonal.aplicacion.usecases;

import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import ec.edu.espe.msvc.reqpersonal.dominio.repositorio.RequisicionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarRequisicionesUseCase {

    private final RequisicionRepositorio repositorio;

    public ListarRequisicionesUseCase(RequisicionRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Requisicion> ejecutar() {
        return repositorio.listarTodas(); // Se usa findAll() directamente de JpaRepository
    }
}
