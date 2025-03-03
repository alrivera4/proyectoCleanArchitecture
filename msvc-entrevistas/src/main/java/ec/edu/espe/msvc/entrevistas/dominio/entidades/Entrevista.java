package ec.edu.espe.msvc.entrevistas.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "entrevista")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entrevista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrevista;

    @ManyToOne
    @JoinColumn(name = "id_candidato", nullable = false)
    private Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "id_vacante", nullable = false)
    private Vacante vacante;

    private LocalDateTime fechaHora;
    private String lugar;
    private String estado; // Ejemplo: "Pendiente", "Realizada", "Cancelada"
}
