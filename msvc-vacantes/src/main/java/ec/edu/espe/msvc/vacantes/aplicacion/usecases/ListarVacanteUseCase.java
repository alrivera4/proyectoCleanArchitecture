package ec.edu.espe.msvc.vacantes.aplicacion.usecase;

import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.VacanteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarVacanteUseCase {
    
    private final VacanteRepositorio repositorio;

    public ListarVacanteUseCase(VacanteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Vacante> ejecutar() {
        return repositorio.findAll();  // 🔹 Reemplaza listarTodas() por findAll()
    }
}
