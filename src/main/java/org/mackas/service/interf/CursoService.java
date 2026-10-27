/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.service.interf;

import java.util.List;
import org.mackas.model.Curso;
import org.mackas.util.CrudRepository;

/**
 *
 * @author Administrador
 */
public interface CursoService extends CrudRepository<Curso,Integer> {
     List<Curso> findByIdAlumno(int idAlumno);
    
}
