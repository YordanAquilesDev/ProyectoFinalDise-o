/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.service.interf;

import java.util.List;
import org.mackas.model.Curso;


/**
 *
 * @author Administrador
 */
public interface ICursoDao {
     List<Curso> findByIdAlumno(int idAlumno);
    
}
