package ec.edu.espe.msvc.vacantes.aplicacion.usecase;

import ec.edu.espe.msvc.vacantes.dominio.entidades.Vacante;
import ec.edu.espe.msvc.vacantes.dominio.repositorio.VacanteRepositorio;
import org.springframework.stereotype.Service;

@Service
public class CerrarVacanteUseCase {
    
    private final VacanteRepositorio repositorio;

    public CerrarVacanteUseCase(VacanteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Long id) {
        Vacante vacante = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacante no encontrada"));
        vacante.setEstado("CERRADA");
        repositorio.save(vacante);
    }
}
