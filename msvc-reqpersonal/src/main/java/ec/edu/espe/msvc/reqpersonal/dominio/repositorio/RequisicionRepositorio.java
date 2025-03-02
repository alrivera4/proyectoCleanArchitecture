package ec.edu.espe.msvc.reqpersonal.dominio.repositorio;

import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import java.util.List;
import java.util.Optional;

public interface RequisicionRepositorio {
    List<Requisicion> listarTodas();
    Requisicion guardar(Requisicion requisicion);
    void eliminar(Long id);
    Optional<Requisicion> buscarPorId(Long id);
    List<Requisicion> findByEstado(String estado);

}
