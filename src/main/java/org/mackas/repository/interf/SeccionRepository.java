/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.repository.interf;

import java.util.List;
import org.mackas.model.Seccion;

/**
 *
 * @author Administrador
 */
public interface SeccionRepository {
      List<Seccion> findByIdPeriodo(int idPeriodo);
      List<Seccion> findByIdDocente(int idDocente);
      List<Seccion> findByIdAlumno(int idEstudiante);
}
