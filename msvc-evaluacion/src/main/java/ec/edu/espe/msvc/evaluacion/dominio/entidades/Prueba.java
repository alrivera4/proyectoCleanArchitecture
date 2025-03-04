package ec.edu.espe.msvc.evaluacion.dominio.entidades;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pruebas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Prueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrueba;
    private int calificacion;
    private String nombre;
    private String descripcion;
    private String tipo; // psicotécnica o técnica
    private boolean activa;

    @ManyToOne
    @JoinColumn(name = "id_candidato", nullable = false)
    private Candidato candidato;  // Relación con Candidato (de msvc-gestcandidatos)

}
