package ec.edu.espe.msvc.entrevistas.presentacion.controlador;

import ec.edu.espe.msvc.entrevistas.dominio.entidades.Entrevista;
import ec.edu.espe.msvc.entrevistas.dominio.entidades.Candidato;
import ec.edu.espe.msvc.entrevistas.dominio.entidades.Vacante;
import ec.edu.espe.msvc.entrevistas.aplicacion.servicio.EntrevistaServicio;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EntrevistaController {

    @Autowired
    private EntrevistaServicio entrevistaServicio;

    // ------------------- Métodos para Consultar Entrevistas -------------------

    @QueryMapping
    public List<Entrevista> obtenerEntrevistasPorCandidato(@Argument Long idCandidato) {
        return entrevistaServicio.obtenerEntrevistasPorCandidato(idCandidato);
    }

    @QueryMapping
    public Entrevista obtenerEntrevistaPorId(@Argument Long id) {
        Optional<Entrevista> entrevista = entrevistaServicio.obtenerEntrevistaPorId(id);
        return entrevista.orElseThrow(() -> new RuntimeException("Entrevista no encontrada con ID: " + id));
    }

    // ------------------- Métodos para Mutaciones de Entrevistas -------------------

    @MutationMapping
    public Entrevista crearEntrevista(@Argument Long candidatoId, @Argument Long vacanteId,
                                      @Argument String fechaHora, @Argument String lugar, @Argument String estado) {

        // Convertir el String a LocalDateTime
        LocalDateTime fechaHoraConvertida = LocalDateTime.parse(fechaHora);

        // Crear la entrevista con los datos recibidos
        Entrevista entrevista = new Entrevista();
        entrevista.setFechaHora(fechaHoraConvertida);
        entrevista.setLugar(lugar);
        entrevista.setEstado(estado);

        // Obtener el candidato y la vacante por sus respectivos IDs
        Optional<Candidato> candidato = entrevistaServicio.obtenerCandidatoPorId(candidatoId);
        Optional<Vacante> vacante = entrevistaServicio.obtenerVacantePorId(vacanteId);

        if (candidato.isPresent() && vacante.isPresent()) {
            entrevista.setCandidato(candidato.get());
            entrevista.setVacante(vacante.get());
        } else {
            throw new RuntimeException("Candidato o Vacante no encontrados.");
        }

        // Guardar la entrevista en la base de datos
        return entrevistaServicio.crearEntrevista(entrevista);
    }
    
    
    @MutationMapping
    public Boolean eliminarEntrevista(@Argument Long id) {
        Optional<Entrevista> entrevistaExistente = entrevistaServicio.obtenerEntrevistaPorId(id);
        if (entrevistaExistente.isPresent()) {
            entrevistaServicio.eliminarEntrevista(id);
            return true;
        } else {
            throw new RuntimeException("Entrevista no encontrada con ID: " + id);
        }
    }
}
