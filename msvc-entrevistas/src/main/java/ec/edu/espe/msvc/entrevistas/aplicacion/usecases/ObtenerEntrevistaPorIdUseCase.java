package ec.edu.espe.msvc.entrevistas.aplicacion.usecases;

import ec.edu.espe.msvc.entrevistas.aplicacion.servicio.EntrevistaServicio;
import ec.edu.espe.msvc.entrevistas.dominio.entidades.Entrevista;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ObtenerEntrevistaPorIdUseCase {

    @Autowired
    private EntrevistaServicio servicioEntrevista;

    // Ejecutar el caso de uso para obtener una entrevista por ID
    public Optional<Entrevista> ejecutar(Long id) {
        return servicioEntrevista.obtenerEntrevistaPorId(id);
    }
}
