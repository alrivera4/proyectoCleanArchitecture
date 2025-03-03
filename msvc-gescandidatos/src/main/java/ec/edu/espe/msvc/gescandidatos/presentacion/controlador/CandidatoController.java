package ec.edu.espe.msvc.gescandidatos.presentacion.controlador;

import ec.edu.espe.msvc.gescandidatos.aplicacion.servicio.CandidatoServicio;
import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Candidato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    private final CandidatoServicio candidatoServicio;

    public CandidatoController(CandidatoServicio candidatoServicio) {
        this.candidatoServicio = candidatoServicio;
    }

    @PostMapping
    public ResponseEntity<Candidato> crearCandidato(@RequestBody Candidato candidato) {
        return ResponseEntity.ok(candidatoServicio.guardarCandidato(candidato));
    }

    @GetMapping
    public ResponseEntity<List<Candidato>> listarCandidatos() {
        return ResponseEntity.ok(candidatoServicio.listarCandidatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> buscarCandidato(@PathVariable Long id) {
        Optional<Candidato> candidato = candidatoServicio.buscarCandidato(id);
        return candidato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCandidato(@PathVariable Long id) {
        candidatoServicio.eliminarCandidato(id);
        return ResponseEntity.noContent().build();
    }
}
