package ec.edu.espe.msvc.gescandidatos.aplicacion.usecases;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarCandidatosUseCase {

    private final CandidatoRepositorio repositorio;

    public ListarCandidatosUseCase(CandidatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // Método para listar todos los candidatos
    public List<Candidato> ejecutar() {
        return repositorio.findAll(); // Usa findAll() de JpaRepository
    }
    
    // Método para listar todos los candidatos
    public List<Candidato> listarTodas() {
        return repositorio.findAll();
    }

    // Método para listar candidatos por estado
    public List<Candidato> listarPorEstado(String estado) {
        return repositorio.findByEstado(estado);
    }

    // Método adicional para contar candidatos por vacante
    public int contarPorVacante(Long idVacante) {
        return repositorio.countByVacanteIdVacante(idVacante); // Asumiendo que existe un método en el repositorio
    }
}