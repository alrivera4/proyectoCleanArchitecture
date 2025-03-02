package ec.edu.espe.msvc.vacantes.dominio.entidades;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Requisicion {
    private Long id;
    private String cargo;
    private String descripcion;
    private String categoriaSalarial;
    private String estado;
}
