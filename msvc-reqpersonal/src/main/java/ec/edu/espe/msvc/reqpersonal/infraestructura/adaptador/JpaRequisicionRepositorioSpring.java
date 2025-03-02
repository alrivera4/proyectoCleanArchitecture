package ec.edu.espe.msvc.reqpersonal.infraestructura.adaptador;
import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaRequisicionRepositorioSpring extends JpaRepository<Requisicion, Long> {
    List<Requisicion> findByEstado(String estado);
}


