package ec.edu.espe.msvc.gescandidatos.presentacion.controlador;

import ec.edu.espe.msvc.gescandidatos.aplicacion.servicio.CandidatoServicio;
import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CandidatoController {

    private final CandidatoServicio candidatoServicio;

    public CandidatoController(CandidatoServicio candidatoServicio) {
        this.candidatoServicio = candidatoServicio;
    }

   /* @MutationMapping
    public Candidato crearCandidato(
            @Argument String nombre,
            @Argument String apellido,
            @Argument String correo,
            @Argument String telefono,
            @Argument String estado,
            @Argument Long idVacante) {

        Candidato candidato = Candidato.builder()
                .nombre(nombre)
                .apellido(apellido)
                .correo(correo)
                .telefono(telefono)
                .estado(estado)
                .build();

        return candidatoServicio.guardarCandidato(candidato, idVacante);
    */
    @MutationMapping
public String crearCandidato(
        @Argument String nombre,
        @Argument String apellido,
        @Argument String correo,
        @Argument String telefono,
        @Argument String estado,
        @Argument Long idVacante) {

    Candidato candidato = Candidato.builder()
            .nombre(nombre)
            .apellido(apellido)
            .correo(correo)
            .telefono(telefono)
            .estado(estado)
            .build();

    return candidatoServicio.guardarCandidato(candidato, idVacante);  // ✅ Ahora devuelve un mensaje manejado
}


    @QueryMapping
    public List<Candidato> listarCandidatos() {
        return candidatoServicio.listarCandidatos();
    }

    @QueryMapping
    public Candidato buscarCandidato(@Argument Long id) {
        return candidatoServicio.buscarCandidato(id).orElse(null);
    }

    @MutationMapping
    public String eliminarCandidato(@Argument Long id) {
        candidatoServicio.eliminarCandidato(id);
        return "Candidato eliminado correctamente";
    }
}
