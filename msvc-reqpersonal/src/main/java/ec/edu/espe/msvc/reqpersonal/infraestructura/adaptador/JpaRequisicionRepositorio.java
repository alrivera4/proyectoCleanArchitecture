/*package ec.edu.espe.msvc.reqpersonal.infraestructura.adaptador;

import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import ec.edu.espe.msvc.reqpersonal.dominio.repositorio.RequisicionRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaRequisicionRepositorio implements RequisicionRepositorio {

    private final RequisicionRepositorio jpaRepositorio;

    public JpaRequisicionRepositorio(RequisicionRepositorio jpaRepositorio) {
        this.jpaRepositorio = jpaRepositorio;
    }

    @Override
    public List<Requisicion> listarTodas() {
        return jpaRepositorio.findAll();
    }

    @Override
    public Requisicion guardar(Requisicion requisicion) {
        return jpaRepositorio.save(requisicion);
    }

    @Override
    public void eliminar(Long id) {
        jpaRepositorio.deleteById(id);
    }

    @Override
    public Optional<Requisicion> buscarPorId(Long id) {
        return jpaRepositorio.findById(id);
    }
    
    @Override
    public List<Requisicion> findByEstado(String estado){
        return jpaRepositorio.findByEstado(estado);
    }
    
    
    
    
    
}*/
