package ec.edu.espe.msvc.entrevistas.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
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
    private String estado;
}





