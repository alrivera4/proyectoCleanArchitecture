/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.msvc.evaluacion.aplicacion.servicio;



import ec.edu.espe.msvc.evaluacion.aplicacion.usecases.CoordinarPruebaUseCase;
import ec.edu.espe.msvc.evaluacion.dominio.entidades.Prueba;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */



import java.util.List;

@Service
public class PruebaServicio {

    private final CoordinarPruebaUseCase coordinarEvaluacionUseCase;

    public PruebaServicio(CoordinarPruebaUseCase coordinarEvaluacionUseCase) {
        this.coordinarEvaluacionUseCase = coordinarEvaluacionUseCase;
    }

    public List<Prueba> obtenerPruebasActivas() {
        return coordinarEvaluacionUseCase.obtenerPruebasActivas();
    }

    public List<Prueba> obtenerPruebasPorTipo(String tipo) {
        return coordinarEvaluacionUseCase.obtenerPruebasPorTipo(tipo);
    }

    public Prueba coordinarPrueba(Prueba prueba) {
        return coordinarEvaluacionUseCase.coordinarPrueba(prueba);
    }
}

