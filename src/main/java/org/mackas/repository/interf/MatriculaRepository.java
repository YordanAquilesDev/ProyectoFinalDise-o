
package org.mackas.repository.interf;

import org.mackas.model.DetalleMatricula;
import org.mackas.model.Matricula;

/**
 *
 * @author Administrador
 */
public interface MatriculaRepository {
      Matricula setMatricula(Matricula mt);
      boolean isMatricula(int idAlumno);
      DetalleMatricula search(int idSeccion, int idAlumno);
}
