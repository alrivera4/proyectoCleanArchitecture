package ec.edu.espe.msvc.evaluacion.presentacion.controlador;

import ec.edu.espe.msvc.evaluacion.aplicacion.usecases.CoordinarPruebaUseCase;
import ec.edu.espe.msvc.evaluacion.dominio.entidades.Candidato;
import ec.edu.espe.msvc.evaluacion.dominio.entidades.Prueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PruebaController {

    @Autowired
    private CoordinarPruebaUseCase coordinarPruebaUseCase;

    // ------------------- Métodos para Consultar Pruebas -------------------
    
    @QueryMapping
    public List<Prueba> obtenerPruebasActivas() {
        return coordinarPruebaUseCase.obtenerPruebasActivas();
    }

    @QueryMapping
    public List<Prueba> obtenerPruebasPorTipo(@Argument String tipo) {
        return coordinarPruebaUseCase.obtenerPruebasPorTipo(tipo);
    }

    @QueryMapping
    public List<Prueba> obtenerPruebasPorCandidato(@Argument Long candidatoId) {
        return coordinarPruebaUseCase.obtenerPruebasPorCandidato(candidatoId);
    }

    // ------------------- Métodos para Mutaciones de Pruebas -------------------

    @MutationMapping
    public Prueba coordinarPrueba(@Argument String nombre, @Argument String descripcion, 
                                  @Argument String tipo, @Argument Long candidatoId) {
        // Crear la prueba con los datos recibidos
        Prueba prueba = new Prueba();
        prueba.setNombre(nombre);
        prueba.setDescripcion(descripcion);
        prueba.setTipo(tipo);
        prueba.setActiva(true);  // Por defecto la prueba está activa

        // Aquí se obtiene el Candidato por su ID, y se asigna a la prueba
        Optional<Candidato> candidato = coordinarPruebaUseCase.obtenerCandidatoPorId(candidatoId);
        if (candidato.isPresent()) {
            prueba.setCandidato(candidato.get());
        } else {
            throw new RuntimeException("Candidato no encontrado con ID: " + candidatoId);
        }

        // Guardar la prueba en la base de datos
        return coordinarPruebaUseCase.coordinarPrueba(prueba);
    }

    @MutationMapping
    public Prueba actualizarPrueba(@Argument Long id, @Argument String nombre, @Argument String descripcion,
                                   @Argument String tipo, @Argument Boolean activa) {
        Optional<Prueba> pruebaExistente = coordinarPruebaUseCase.obtenerPruebaPorId(id);
        if (pruebaExistente.isPresent()) {
            Prueba prueba = pruebaExistente.get();
            prueba.setNombre(nombre);
            prueba.setDescripcion(descripcion);
            prueba.setTipo(tipo);
            prueba.setActiva(activa);
            return coordinarPruebaUseCase.coordinarPrueba(prueba);
        } else {
            throw new RuntimeException("Prueba no encontrada con ID: " + id);
        }
    }

    @MutationMapping
    public Boolean eliminarPrueba(@Argument Long id) {
        Optional<Prueba> pruebaExistente = coordinarPruebaUseCase.obtenerPruebaPorId(id);
        if (pruebaExistente.isPresent()) {
            coordinarPruebaUseCase.eliminarPrueba(id);
            return true;
        } else {
            throw new RuntimeException("Prueba no encontrada con ID: " + id);
        }
    }
}
