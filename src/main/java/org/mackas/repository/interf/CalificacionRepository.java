/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.repository.interf;

import java.util.List;
import org.mackas.model.Calificacion;
import org.mackas.util.CrudRepository;

/**
 *
 * @author Administrador
 */
public interface CalificacionRepository extends CrudRepository<Calificacion,Integer>{
    List<Calificacion> findByIdCursoAlumno(int idCurso,int idAlumno);
}
