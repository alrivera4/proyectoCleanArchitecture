package ec.edu.espe.msvc.entrevistas.aplicacion.usecases;

import ec.edu.espe.msvc.entrevistas.aplicacion.servicio.EntrevistaServicio;
import ec.edu.espe.msvc.entrevistas.dominio.entidades.Entrevista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearEntrevistaUseCase {

    @Autowired
    private EntrevistaServicio servicioEntrevista;

    // Ejecutar el caso de uso para crear una entrevista
    public Entrevista ejecutar(Entrevista entrevista) {
        return servicioEntrevista.crearEntrevista(entrevista);
    }
}
