package ec.edu.espe.msvc.vacantes.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vacantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacante;

    private String cargo;
    private String descripcion;
    private String categoriaSalarial;
    private String estado; // "ABIERTA", "CERRADA"
    private LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_requisicion", nullable = false)
    private Requisicion requisicion;
        
}
