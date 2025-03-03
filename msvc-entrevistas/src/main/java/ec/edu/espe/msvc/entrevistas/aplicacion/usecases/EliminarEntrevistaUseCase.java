package ec.edu.espe.msvc.entrevistas.aplicacion.usecases;

import ec.edu.espe.msvc.entrevistas.aplicacion.servicio.EntrevistaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EliminarEntrevistaUseCase {

    @Autowired
    private EntrevistaServicio servicioEntrevista;

    // Ejecutar el caso de uso para eliminar una entrevista
    public void ejecutar(Long id) {
        servicioEntrevista.eliminarEntrevista(id);
    }
}
