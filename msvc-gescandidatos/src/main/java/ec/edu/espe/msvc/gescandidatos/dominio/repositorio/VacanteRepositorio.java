/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.msvc.gescandidatos.dominio.repositorio;

import ec.edu.espe.msvc.gescandidatos.dominio.entidades.Vacante;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Douglas
 */
@Repository
public interface VacanteRepositorio extends JpaRepository<Vacante, Long> {

    // Método para buscar una vacante por su ID
    Optional<Vacante> findById(Long id);

    // Puedes agregar otros métodos de consulta según sea necesario
    // Ejemplo: listar todas las vacantes activas
    // List<Vacante> findByActivo(Boolean activo);
}