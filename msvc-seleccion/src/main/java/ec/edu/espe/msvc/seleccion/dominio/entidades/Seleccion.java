package ec.edu.espe.msvc.seleccion.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "selecciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeleccion;

    @ManyToOne
    @JoinColumn(name = "id_candidato", nullable = false)
    private Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "id_vacante", nullable = false)
    private Vacante vacante;

    
    private String resultadoEvaluacion;  // Ejemplo: "Aprobado", "Rechazado"
    private String recomendaciones;
}

