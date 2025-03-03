package ec.edu.espe.msvc.gescandidatos.infraestructura.adaptador;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCandidatoRepositorio implements CandidatoRepositorio{

    private final CandidatoRepositorio candidatoRepositorio;

    public JpaCandidatoRepositorio(CandidatoRepositorio candidatoRepositorio) {
        this.candidatoRepositorio = candidatoRepositorio;
    }
    @Override
    public List<Candidato> listarTodas() {
        return candidatoRepositorio.listarTodas();
    }
    @Override
    public Optional<Candidato> buscarPorId(Long id) {
        return candidatoRepositorio.buscarPorId(id);
    }
    @Override
    public Candidato guardar(Candidato candidato) {
        return candidatoRepositorio.guardar(candidato);
    }
    @Override
    public void eliminar(Long id) {
        candidatoRepositorio.eliminar(id);
    }
    @Override
    public List<Candidato> findByEstado(String estado){
        return candidatoRepositorio.findByEstado(estado);
    }
}
