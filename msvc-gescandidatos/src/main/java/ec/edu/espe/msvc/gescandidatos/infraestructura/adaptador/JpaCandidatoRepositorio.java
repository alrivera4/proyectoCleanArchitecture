/*package ec.edu.espe.msvc.gescandidatos.infraestructura.adaptador;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import ec.edu.espe.msvc.gescandidatos.dominio.repositorio.CandidatoRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCandidatoRepositorio implements CandidatoRepositorio{

    
    private final JpaCandidatoRepositorioSpring jpaRepositorio;

    public JpaCandidatoRepositorio(JpaCandidatoRepositorioSpring jpaRepositorio) {
        this.jpaRepositorio = jpaRepositorio;
    }
    
    @Override
    public List<Candidato> listarTodas() {
        return jpaRepositorio.findAll();
    }
    @Override
    public Optional<Candidato> buscarPorId(Long id) {
        return jpaRepositorio.findById(id);
    }
    @Override
    public Candidato guardar(Candidato candidato) {
        return jpaRepositorio.save(candidato);
    }
    @Override
    public void eliminar(Long id) {
        jpaRepositorio.deleteById(id);
    }
    @Override
    public List<Candidato> findByEstado(String estado){
        return jpaRepositorio.findByEstado(estado);
    }
}*/
