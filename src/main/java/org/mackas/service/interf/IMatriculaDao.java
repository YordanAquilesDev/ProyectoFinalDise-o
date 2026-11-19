/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.service.interf;

import org.mackas.model.DetalleMatricula;
import org.mackas.model.Matricula;

/**
 *
 * @author Administrador
 */
public interface IMatriculaDao {
    Matricula setMatricula(Matricula mt);    
      boolean isMatricula(int idAlumno);
       public DetalleMatricula search(int idSeccion, int idAlumno);
       public Matricula search(int idAlumno);
}
