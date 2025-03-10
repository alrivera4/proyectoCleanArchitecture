package ec.edu.espe.msvc.reqpersonal.dominio.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "requisicion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Requisicion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequisicion;
    private String cargo;
    private String descripcion;
    private String categoriaSalarial;
    private String estado; // "PENDIENTE", "APROBADA", "RECHAZADA"
    private LocalDate fechaSolicitud;
}
