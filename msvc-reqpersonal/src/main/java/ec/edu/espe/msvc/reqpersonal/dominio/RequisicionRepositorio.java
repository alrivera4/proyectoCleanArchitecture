/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.msvc.reqpersonal.dominio;
import ec.edu.espe.msvc.reqpersonal.dominio.entidades.Requisicion;

import java.util.List;

/**
 *
 * @author lilia
 */


public interface RequisicionRepositorio {
    List<Requisicion> listarTodas();
    Requisicion guardar(Requisicion requisicion);
    void eliminar(Long id);
}
