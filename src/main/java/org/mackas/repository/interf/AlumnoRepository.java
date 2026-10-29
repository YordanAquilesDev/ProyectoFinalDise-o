package org.mackas.repository.interf;

import java.util.List;
import org.mackas.model.Alumno;
import org.mackas.util.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno,Integer> {
 Alumno findByIdUser(int  idUser);
 List<Alumno> findByIdSeccion(int idSeccion);
 
}
