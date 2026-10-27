package org.mackas.repository.interf;

import java.util.List;
import org.mackas.model.Alumno;
import org.mackas.util.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno,Integer> {
 Alumno findByCodigo(String codigo);
 List<Alumno> findByIdSeccion(int idSeccion);
}
