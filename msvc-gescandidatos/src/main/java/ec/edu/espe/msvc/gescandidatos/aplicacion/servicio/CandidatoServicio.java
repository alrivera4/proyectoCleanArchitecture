package ec.edu.espe.msvc.gescandidatos.aplicacion.servicio;

import ec.edu.espe.msvc.gescandidatos.dominio.dto.VacanteDTO;
import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.infraestructura.cliente.VacanteCliente;
import ec.edu.espe.msvc.gescandidatos.infraestructura.adaptador.JpaCandidatoRepositorioSpring;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoServicio {

    private final JpaCandidatoRepositorioSpring candidatoRepositorio;
    private final VacanteCliente vacanteCliente;

    public CandidatoServicio(JpaCandidatoRepositorioSpring candidatoRepositorio, VacanteCliente vacanteCliente) {
        this.candidatoRepositorio = candidatoRepositorio;
        this.vacanteCliente = vacanteCliente;
    }

    public List<Candidato> listarCandidatos() {
        return candidatoRepositorio.findAll();
    }

    public Optional<Candidato> buscarCandidato(Long id) {
        Optional<Candidato> candidato = candidatoRepositorio.findById(id);
        if (candidato.isPresent()) {
            VacanteDTO vacante = vacanteCliente.obtenerVacante(candidato.get().getIdVacante());
        }
        return candidato;
    }

    public Candidato guardarCandidato(Candidato candidato) {
        return candidatoRepositorio.save(candidato);
    }

    public void eliminarCandidato(Long id) {
        candidatoRepositorio.deleteById(id);
    }
}
