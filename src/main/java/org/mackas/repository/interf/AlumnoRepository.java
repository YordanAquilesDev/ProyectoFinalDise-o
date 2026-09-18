package org.mackas.repository.interf;

import org.mackas.model.Alumno;
import org.mackas.util.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno,Integer> {
 Alumno findByCodigo(String codigo);
}
