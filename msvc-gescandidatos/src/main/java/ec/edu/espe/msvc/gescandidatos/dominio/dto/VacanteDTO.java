package ec.edu.espe.msvc.gescandidatos.dominio.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import lombok.Data;

@Data
public class VacanteDTO {
    private Long idVacante;
    private String cargo;
    private String descripcion;
    private String categoriaSalarial;
    private String estado;
    private LocalDate fechaPublicacion;
}
