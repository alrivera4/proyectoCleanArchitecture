package ec.edu.espe.msvc.seleccion.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidato")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidato;

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_vacante", nullable = false)
    private Vacante vacante;
}
