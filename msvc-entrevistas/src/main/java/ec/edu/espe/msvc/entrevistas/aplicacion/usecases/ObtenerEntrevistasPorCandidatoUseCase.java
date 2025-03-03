package ec.edu.espe.msvc.entrevistas.aplicacion.usecases;

import ec.edu.espe.msvc.entrevistas.aplicacion.servicio.EntrevistaServicio;
import ec.edu.espe.msvc.entrevistas.dominio.entidades.Entrevista;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ObtenerEntrevistasPorCandidatoUseCase {

    @Autowired
    private EntrevistaServicio servicioEntrevista;

    // Ejecutar el caso de uso para obtener entrevistas por candidato
    public List<Entrevista> ejecutar(Long idCandidato) {
        return servicioEntrevista.obtenerEntrevistasPorCandidato(idCandidato);
    }
}
