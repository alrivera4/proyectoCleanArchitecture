package ec.edu.espe.msvc.vacantes.aplicacion.servicio;

import ec.edu.espe.msvc.vacantes.aplicacion.usecase.CrearVacanteUseCase;
import ec.edu.espe.msvc.vacantes.aplicacion.usecase.ListarVacanteUseCase;
import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.VacanteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacanteServicio {

    private final CrearVacanteUseCase crearVacanteUseCase;
    private final ListarVacanteUseCase listarVacanteUseCase;
    private final VacanteRepositorio vacanteRepositorio;

    public VacanteServicio(CrearVacanteUseCase crearVacanteUseCase,
                           ListarVacanteUseCase listarVacanteUseCase,
                           VacanteRepositorio vacanteRepositorio) {
        this.crearVacanteUseCase = crearVacanteUseCase;
        this.listarVacanteUseCase = listarVacanteUseCase;
        this.vacanteRepositorio = vacanteRepositorio;
    }

    public Vacante crearVacante(String cargo, String descripcion, String categoriaSalarial, Long idRequisicion) {
        Vacante vacante = new Vacante(null, cargo, descripcion, categoriaSalarial, "ABIERTA", null, idRequisicion);
        return vacanteRepositorio.save(vacante);
    }

    public List<Vacante> listarVacantes() {
        return vacanteRepositorio.findAll();
    }
    public List<Vacante> obtenerVacantesPorRequisicion(Long idRequisicion) {
    return vacanteRepositorio.findByIdRequisicion(idRequisicion);
}

}
