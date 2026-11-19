/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.service.interf;

import java.util.List;
import org.mackas.model.Calificacion;

/**
 *
 * @author Administrador
 */
public interface ICalificacionDao {
      List<Calificacion> findByIdCursoAlumno(int idCurso,int idAlumno);
      Calificacion save(Calificacion c);
}
