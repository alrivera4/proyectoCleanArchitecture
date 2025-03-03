/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.msvc.seleccion.dominio.repositorio;

import ec.edu.espe.msvc.seleccion.dominio.entidades.Seleccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */

@Repository
public interface SeleccionRepositorio extends JpaRepository<Seleccion, Long> {
    List<Seleccion> findByCandidatoIdCandidato(Long idCandidato);
}